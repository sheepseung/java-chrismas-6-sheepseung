package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ChrismasEventController implements EventController {
    private static final int D_DAY_DISCOUNT_START_VALUE = 1000;
    private static final int D_DAY_DISCOUNT_VALUE = 100;
    private static final int STAND_DISCOUNT_VALUE = 2023;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    private static final String discountDetails = "";

    public static final DecemberCalendar decemberCalendar = new DecemberCalendar();

    public void dDayDiscountEvent(ReservationDay reservationDay, Bill bill) {
        if (reservationDay.dDayDiscountEventPeriod()) {
            BigDecimal discountValue = new BigDecimal(D_DAY_DISCOUNT_START_VALUE +
                    ((reservationDay.getDay() - 1) * D_DAY_DISCOUNT_VALUE));

            bill.discountPrice(discountValue);
            addContentsDDayDiscountEvent(discountValue);
        }
    }

    private void addContentsDDayDiscountEvent(BigDecimal discountValue){
        String discountDetail = ("크리스마스 디데이 할인: -" + DECIMAL_FORMAT.format(discountValue) + "원\n");
        discountDetails.concat(discountDetail);
    }

    public void weekDayDiscountEvent(ReservationDay day, Order order, Bill bill) {
        if(decemberCalendar.isWeekday(day.getDay())){
            long dessertCount = order.getOrderDetails().stream()
                    .filter(orderedMenu -> "dessert".equals(orderedMenu.getMenu().getMenuItem().getMenuType()))
                    .count();
            BigDecimal discountValue = new BigDecimal(dessertCount * STAND_DISCOUNT_VALUE);

            bill.discountPrice(discountValue);
            addContentsWeekdayDiscountEvent(discountValue);
        }
    }

    private void addContentsWeekdayDiscountEvent(BigDecimal discountValue){
        if(discountValue.compareTo(new BigDecimal(0)) == 0) {
            String discountDetail = ("평일 할인: -" + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails.concat(discountDetail);
        }
    }


    public void weekendDayDiscount(int day) {
        if(decemberCalendar.isWeekendDay(day)){

        }
    }

    public void specialDayDiscountEvent(int day) {
        if(decemberCalendar.isSpecialDay(day)){

        }
    }

    public void presentEvent() {

    }

    public void badgeEvent() {

    }
}
