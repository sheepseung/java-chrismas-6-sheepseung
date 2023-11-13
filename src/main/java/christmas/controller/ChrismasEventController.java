package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.dto.ReservationDay;
import java.math.BigDecimal;

public class ChrismasEventController implements EventController{
    private static final int D_DAY_DISCOUNT_START_VALUE = 1000;
    private static final int D_DAY_DISCOUNT_VALUE = 100;

    private final DecemberCalendar decemberCalendar = new DecemberCalendar();

    public void dDayDiscountEvent(ReservationDay reservationDay, Bill bill){
        BigDecimal discountValue = new BigDecimal(D_DAY_DISCOUNT_START_VALUE +
                (reservationDay.getDay() * D_DAY_DISCOUNT_VALUE));

        bill.discountPrice(discountValue);
    }

    public void weekDayDiscountEvent(){

    }

    public void weekEndDayDiscount(){

    }

    public void specialDiscountEvent(){

    }

    public void presentEvent(){

    }

    public void badgeEvent(){

    }

}
