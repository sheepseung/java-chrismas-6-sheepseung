package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final Orders orders;

    public PlannerController(){
        this.orders = new Orders();
    }

    public void run(){
        OutputView.printStartMessage();
        int date = InputView.inputDate();
        ReservationDay day = new ReservationDay(date);

        String orderedMenu = InputView.inputOrder();
        orders.takeOrder(orderedMenu);


    }
}
