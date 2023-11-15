package christmas.controller;

import christmas.domain.*;
import christmas.utils.EventSettings;
import christmas.parser.EventDetailsParser;
import christmas.view.EventView;

import java.math.BigDecimal;
import java.util.Map;

public class ChristmasEventController implements EventController {
    private static final String WEEKDAY_DISCOUNT_TYPE = "dessert";
    private static final String WEEKEND_DISCOUNT_TYPE = "main";
    private static final DecemberCalendar decemberCalendar = new DecemberCalendar();

    private boolean canPresent = false;
    private BigDecimal totalBenefitAmount = new BigDecimal(0);
    private Map<Menu, Integer> orderDetails;
    private Badge badge;
    private String eventResultDetails = "";
    private BigDecimal beforeEventApplied;

    public void applyEvent(ReservationDay reservationDay, Order order, Bill bill) {
        beforeEventApplied = bill.getTotalPrice();
        if (bill.getTotalPrice().compareTo(EventSettings.EVENT_APPLY_STAND.getAmount()) >= 0) {
            this.orderDetails = order.getOrderDetails();
            presentEvent(bill);
            dDayDiscountEvent(reservationDay, bill);
            weekdayDiscountEvent(reservationDay, bill);
            weekendDiscountEvent(reservationDay, bill);
            specialDayDiscountEvent(reservationDay, bill);
            badgeEvent(totalBenefitAmount);
        }
    }

    public void presentEvent(Bill bill) {
        if (bill.getTotalPrice().compareTo(EventSettings.PRESENT_STANDARD_AMOUNT.getAmount()) == 1) {
            canPresent = true;
            BigDecimal benefitValue = EventSettings.PRESENT_VALUE.getAmount();

            totalBenefitAmount = totalBenefitAmount.add(benefitValue);
            eventResultDetails += EventDetailsParser.parsePresentEventDetail(benefitValue);
        }
    }

    public void dDayDiscountEvent(ReservationDay reservationDay, Bill bill) {
        if (reservationDay.dDayDiscountEventPeriod()) {
            BigDecimal eventDay = new BigDecimal(reservationDay.getDay() - 1);
            BigDecimal discountValue = EventSettings.D_DAY_DISCOUNT_START_VALUE.getAmount().
                    add((EventSettings.D_DAY_DISCOUNT_VALUE.getAmount().multiply(eventDay)));

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventResultDetails += EventDetailsParser.parseDDayDiscountEventDetail(discountValue);
        }
    }

    public void weekdayDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isWeekday(day.getDay())) {
            long dessertCount = orderDetails.entrySet().stream()
                    .filter(entry -> WEEKDAY_DISCOUNT_TYPE.equals(entry.getKey().getMenuItem().getMenuType()))
                    .mapToLong(Map.Entry::getValue)
                    .sum();
            BigDecimal discountValue = new BigDecimal(dessertCount)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventResultDetails += EventDetailsParser.parseWeekdayDiscountEventDetail(discountValue);
        }
    }

    public void weekendDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isWeekend(day.getDay())) {
            long mainDishCount = orderDetails.entrySet().stream()
                    .filter(entry -> WEEKEND_DISCOUNT_TYPE.equals(entry.getKey().getMenuItem().getMenuType()))
                    .mapToLong(Map.Entry::getValue)
                    .sum();
            BigDecimal discountValue = new BigDecimal(mainDishCount)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventResultDetails += EventDetailsParser.parseWeekendDiscountEventDetail(discountValue);
        }
    }

    public void specialDayDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isSpecialDay(day.getDay())) {
            BigDecimal discountValue = EventSettings.SPECIAL_DAY_DISCOUNT_VALUE.getAmount();

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventResultDetails += EventDetailsParser.paresSpecialDayDiscountEventDetail(discountValue);
        }
    }

    public void badgeEvent(BigDecimal totalBenefitAmount) {
        badge = Badge.getBadge(totalBenefitAmount);
    }

    public void showEventDiscountDetails(Bill bill) {
        EventView.printPriceBeforeDiscount(beforeEventApplied);
        EventView.printPresentDetails(canPresent);
        EventView.printEventResultDetails(eventResultDetails);
        EventView.printTotalBenefitAmount(totalBenefitAmount);
        EventView.printPriceAfterDiscount(bill);
        EventView.printBadge(badge);
    }
}
