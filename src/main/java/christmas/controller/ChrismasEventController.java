package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;
import christmas.dto.ReservationDay;

import java.math.BigDecimal;

public class ChrismasEventController implements EventController{
    private static final int D_DAY_DISCOUNT_VALUE = 1000;

    private final DecemberCalendar decemberCalendar;
    private final Order order;
    private final Bill bill;

    public ChrismasEventController(Order order) {
        this.decemberCalendar = new DecemberCalendar();
        this.order = order;
        this.bill = new Bill(order);
    }

    public void dDayDiscountEvent(ReservationDay reservationDay){
        BigDecimal discountValue = new BigDecimal(reservationDay.getDay() * D_DAY_DISCOUNT_VALUE);
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
