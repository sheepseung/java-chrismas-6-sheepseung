package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.domain.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final Order order;
    private final ReservationDay reservationDay;
    private final EventController eventController;

    private Bill bill;

    public PlannerController(EventController eventController) {
        this.eventController = eventController;
        this.reservationDay = new ReservationDay();
        this.order = new Order();
    }

    public void run() {
        OutputView.printStartMessage();
        inputDay();
        inputOrder();
        try {
            OutputView.printEventPreviewMessage(reservationDay.getDay());
            OutputView.printOrderDetails(order);

            bill = new Bill(order);

            eventController.applyEvent(reservationDay, order, bill);
            eventController.showEventDiscountDetails(bill);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void inputDay() {
        String dayInput = InputView.inputDate();
        reservationDay.reserveDay(dayInput);
    }

    private void inputOrder() {
        String orderInput = InputView.inputOrder();
        order.takeOrder(orderInput.replace(" ", ""));
    }
}
