package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    ReservationDay reservationDay;
    Orders orders;

    public void run() {
        OutputView.printStartMessage();
        inputDay();
        inputOrder();

        OutputView.printEventPreviewMessage(reservationDay.getDay());
        OutputView.printOrderDetails(orders);
    }

    private void inputDay() {
        int date = InputView.inputDate();
        reservationDay = new ReservationDay(date);
    }

    private void inputOrder() {
        String orderInput = InputView.inputOrder();
        orders = new Orders(orderInput);
    }
}
