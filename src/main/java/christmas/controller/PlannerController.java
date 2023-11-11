package christmas.controller;

import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    ReservationDay reservationDay;
    Order order;

    public void run() {
        OutputView.printStartMessage();
        inputDay();
        inputOrder();

        OutputView.printEventPreviewMessage(reservationDay.getDay());
        OutputView.printOrderDetails(order);
    }

    private void inputDay() {
        int date = InputView.inputDate();
        reservationDay = new ReservationDay(date);
    }

    private void inputOrder() {
        String orderInput = InputView.inputOrder();
        order = new Order(orderInput.replace(" ", ""));
    }
}
