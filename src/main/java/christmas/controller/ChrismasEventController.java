package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.DecemberCalendar;
import christmas.domain.Order;

public class ChrismasEventController {
    private final DecemberCalendar decemberCalendar;
    private final Order order;
    private final Bill bill;

    public ChrismasEventController(Order order) {
        this.decemberCalendar = new DecemberCalendar();
        this.order = order;
        this.bill = new Bill(order);
    }

    public void dDayDiscountEvent(){

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
