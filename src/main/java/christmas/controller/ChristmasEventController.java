package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;
import christmas.domain.ReservationDay;
import christmas.enums.Badge;
import christmas.enums.EventSettings;
import christmas.enums.Menu;
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
    private String eventDetails = "";

    public void applyEvent(ReservationDay reservationDay, Order order, Bill bill) {
        this.orderDetails = order.getOrderDetails();
        presentEvent(bill);
        dDayDiscountEvent(reservationDay, bill);
        weekdayDiscountEvent(reservationDay, bill);
        weekendDiscountEvent(reservationDay, bill);
        specialDayDiscountEvent(reservationDay, bill);
    }

    private void presentEvent(Bill bill) {
        if (bill.getTotalPrice().compareTo(EventSettings.PRESENT_STANDARD_AMOUNT.getAmount()) == 1) {
            canPresent = true;
            BigDecimal benefitValue = EventSettings.PRESENT_VALUE.getAmount();

            totalBenefitAmount = totalBenefitAmount.add(benefitValue);
            eventDetails += EventDetailsParser.parsePresentEventDetail(benefitValue);
        }
    }

    private void dDayDiscountEvent(ReservationDay reservationDay, Bill bill) {
        if (reservationDay.dDayDiscountEventPeriod()) {
            BigDecimal eventDay = new BigDecimal(reservationDay.getDay() - 1);
            BigDecimal discountValue = EventSettings.D_DAY_DISCOUNT_START_VALUE.getAmount().
                    add((EventSettings.D_DAY_DISCOUNT_VALUE.getAmount().multiply(eventDay)));

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventDetails += EventDetailsParser.parseDDayDiscountEventDetail(discountValue);
        }
    }

    private void weekdayDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isWeekday(day.getDay())) {
            long dessertCount = orderDetails.entrySet().stream()
                    .filter(entry -> WEEKDAY_DISCOUNT_TYPE.equals(entry.getKey().getMenuItem().getMenuType()))
                    .mapToLong(Map.Entry::getValue)
                    .sum();

            BigDecimal discountValue = new BigDecimal(dessertCount)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventDetails += EventDetailsParser.parseWeekdayDiscountEventDetail(discountValue);
        }
    }

    private void weekendDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isWeekend(day.getDay())) {
            long mainDishCount = orderDetails.entrySet().stream()
                    .filter(entry -> WEEKEND_DISCOUNT_TYPE.equals(entry.getKey().getMenuItem().getMenuType()))
                    .mapToLong(Map.Entry::getValue)
                    .sum();

            BigDecimal discountValue = new BigDecimal(mainDishCount)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventDetails += EventDetailsParser.parseWeekendDiscountEventDetail(discountValue);
        }
    }

    private void specialDayDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isSpecialDay(day.getDay())) {
            BigDecimal discountValue = EventSettings.SPECIAL_DAY_DISCOUNT_VALUE.getAmount();

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            eventDetails += EventDetailsParser.paresSpecialDayDiscountEventDetail(discountValue);
        }
    }

    public void showEventDiscountDetails(Bill bill) {
        EventView.printPriceBeforeDiscount(bill);
        EventView.printPresentDetails(canPresent);
        EventView.printEventDiscountDetails(eventDetails);
        EventView.printTotalBenefitAmount(totalBenefitAmount);
        EventView.printBadge(Badge.getBadge(totalBenefitAmount));
        EventView.printPriceAfterDiscount(bill);
    }
}
