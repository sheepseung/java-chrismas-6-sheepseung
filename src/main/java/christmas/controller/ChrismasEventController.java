package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.enums.OutputMessage;
import christmas.view.OutputView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ChrismasEventController implements EventController {
    private static final int D_DAY_DISCOUNT_START_VALUE = 1000;
    private static final int D_DAY_DISCOUNT_VALUE = 100;
    private static final int STAND_DISCOUNT_VALUE = 2023;
    private static final String WEEKDAY_DISCOUNT_TYPE = "dessert";
    private static final String WEEKEND_DISCOUNT_TYPE = "main";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    private String discountDetails = "";

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
        String discountDetail = (OutputMessage.D_DAY_DISCOUNT_MESSAGE.getMessage()
                + DECIMAL_FORMAT.format(discountValue) + "원\n");
        discountDetails += discountDetail;
    }

    public void weekdayDiscountEvent(ReservationDay day, Order order, Bill bill) {
        if(decemberCalendar.isWeekday(day.getDay())){
            long dessertCount = order.getOrderDetails().stream()
                    .filter(orderedMenu -> WEEKDAY_DISCOUNT_TYPE.equals(orderedMenu.getMenu().getMenuItem().getMenuType()))
                    .count();
            BigDecimal discountValue = new BigDecimal(dessertCount * STAND_DISCOUNT_VALUE);

            bill.discountPrice(discountValue);
            addContentsWeekdayDiscountEvent(discountValue);
        }
    }

    private void addContentsWeekdayDiscountEvent(BigDecimal discountValue){
        if(discountValue.compareTo(new BigDecimal(0)) != 0) {
            String discountDetail = (OutputMessage.WEEKDAY_DISCOUNT_MESSAGE.getMessage()
                    + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails += discountDetail;
        }
    }


    public void weekendDiscountEvent(ReservationDay day, Order order, Bill bill) {
        if(decemberCalendar.isWeekend(day.getDay())){
            long dessertCount = order.getOrderDetails().stream()
                    .filter(orderedMenu -> WEEKEND_DISCOUNT_TYPE.equals(orderedMenu.getMenu().getMenuItem().getMenuType()))
                    .count();
            BigDecimal discountValue = new BigDecimal(dessertCount * STAND_DISCOUNT_VALUE);

            bill.discountPrice(discountValue);
            addContentsWeekendDiscountEvent(discountValue);
        }
    }

    private void addContentsWeekendDiscountEvent(BigDecimal discountValue){
        if(discountValue.compareTo(new BigDecimal(0)) != 0) {
            String discountDetail = (OutputMessage.WEEKEND_DISCOUNT_MESSAGE.getMessage()
                    + DECIMAL_FORMAT.format(discountValue) + "원\n");
            discountDetails += discountDetail;
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

    public void showEventDiscountDetails(){
        OutputView.printEventDiscountDetails(discountDetails);
    }
}
