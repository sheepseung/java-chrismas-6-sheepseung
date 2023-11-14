package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.enums.Badge;
import christmas.enums.EventSettings;
import christmas.enums.OutputMessage;
import christmas.view.EventView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ChristmasEventController implements EventController {
    private static final String WEEKDAY_DISCOUNT_TYPE = "dessert";
    private static final String WEEKEND_DISCOUNT_TYPE = "main";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    private String discountDetails = "";
    private boolean canPresent = false;
    private BigDecimal totalBenefitAmount = new BigDecimal(0);

    public static final DecemberCalendar decemberCalendar = new DecemberCalendar();

    public void applyEvent(ReservationDay reservationDay, Order order, Bill bill) {
        presentEvent(bill);
        dDayDiscountEvent(reservationDay, bill);
        weekdayDiscountEvent(reservationDay, order, bill);
        weekendDiscountEvent(reservationDay, order, bill);
        specialDayDiscountEvent(reservationDay, bill);
    }

    private void presentEvent(Bill bill) {
        if (bill.getTotalPrice().compareTo(EventSettings.PRESENT_STANDARD_AMOUNT.getAmount()) == 1) {
            canPresent = true;
            addContentsPresentEvent(EventSettings.PRESENT_VALUE.getAmount());
            totalBenefitAmount = totalBenefitAmount.add(EventSettings.PRESENT_VALUE.getAmount());
        }
    }

    private void addContentsPresentEvent(BigDecimal discountValue) {
        String discountDetail = (OutputMessage.PRESENT_DISCOUNT_MESSAGE.getMessage()
                + DECIMAL_FORMAT.format(discountValue) + "원\n");
        discountDetails += discountDetail;
    }

    private void dDayDiscountEvent(ReservationDay reservationDay, Bill bill) {
        if (reservationDay.dDayDiscountEventPeriod()) {
            BigDecimal eventDay = new BigDecimal(reservationDay.getDay()-1);
            BigDecimal discountValue = EventSettings.D_DAY_DISCOUNT_START_VALUE.getAmount().
                    add((EventSettings.D_DAY_DISCOUNT_VALUE.getAmount().multiply(eventDay)));

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            addContentsDDayDiscountEvent(discountValue);
        }
    }

    private void addContentsDDayDiscountEvent(BigDecimal discountValue) {
        String discountDetail = (OutputMessage.D_DAY_DISCOUNT_MESSAGE.getMessage()
                + DECIMAL_FORMAT.format(discountValue) + "원\n");
        discountDetails += discountDetail;
    }

    private void weekdayDiscountEvent(ReservationDay day, Order order, Bill bill) {
        if (decemberCalendar.isWeekday(day.getDay())) {
            long count = order.getOrderDetails().stream()
                    .filter(orderedMenu -> WEEKDAY_DISCOUNT_TYPE.equals(orderedMenu.getMenu().getMenuItem().getMenuType()))
                    .mapToLong(orderedMenu -> orderedMenu.getCount())
                    .sum();

            BigDecimal discountValue = new BigDecimal(count)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            addContentsWeekdayDiscountEvent(discountValue);
        }
    }

    private void addContentsWeekdayDiscountEvent(BigDecimal discountValue) {
        if (discountValue.compareTo(new BigDecimal(0)) != 0) {
            String discountDetail = (OutputMessage.WEEKDAY_DISCOUNT_MESSAGE.getMessage()
                    + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails += discountDetail;
        }
    }

    private void weekendDiscountEvent(ReservationDay day, Order order, Bill bill) {
        if (decemberCalendar.isWeekend(day.getDay())) {
            long mainDishCount = order.getOrderDetails().stream()
                    .filter(orderedMenu -> WEEKEND_DISCOUNT_TYPE.equals(orderedMenu.getMenu().getMenuItem().getMenuType()))
                    .mapToLong(orderedMenu -> orderedMenu.getCount())
                    .sum();

            BigDecimal discountValue = new BigDecimal(mainDishCount)
                    .multiply(EventSettings.STANDARD_DISCOUNT_VALUE.getAmount());

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            addContentsWeekendDiscountEvent(discountValue);
        }
    }

    private void addContentsWeekendDiscountEvent(BigDecimal discountValue) {
        if (discountValue.compareTo(new BigDecimal(0)) != 0) {
            String discountDetail = (OutputMessage.WEEKEND_DISCOUNT_MESSAGE.getMessage()
                    + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails += discountDetail;
        }
    }

    private void specialDayDiscountEvent(ReservationDay day, Bill bill) {
        if (decemberCalendar.isSpecialDay(day.getDay())) {
            BigDecimal discountValue = EventSettings.SPECIAL_DAY_DISCOUNT_VALUE.getAmount();

            bill.discountPrice(discountValue);
            totalBenefitAmount = totalBenefitAmount.add(discountValue);
            addContentsSpecialDayDiscountEvent(discountValue);
        }
    }

    private void addContentsSpecialDayDiscountEvent(BigDecimal discountValue) {
        if (discountValue.compareTo(new BigDecimal(0)) == 1) {
            String discountDetail = (OutputMessage.SPECIAL_DAY_DISCOUNT_MESSAGE.getMessage()
                    + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails += discountDetail;
        }
    }

    public void showEventDiscountDetails() {
        EventView.printPresentDetails(canPresent);
        EventView.printEventDiscountDetails(discountDetails);
        EventView.printTotalBenefitAmount(totalBenefitAmount);
        EventView.printBadge(Badge.getBadge(totalBenefitAmount));
    }
}