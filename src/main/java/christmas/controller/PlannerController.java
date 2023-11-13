package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private ReservationDay reservationDay;
    private Order order = new Order();
    private Bill bill;
    private final EventController eventController;

    public PlannerController(EventController eventController) {
        this.eventController = eventController;
    }

    public void run() {
        OutputView.printStartMessage();
        inputDay();
        inputOrder();

        OutputView.printEventPreviewMessage(reservationDay.getDay());
        OutputView.printOrderDetails(order);

        bill = new Bill(order);
        OutputView.printPriceBeforeDiscount(bill);

        eventController.dDayDiscountEvent(reservationDay, bill);
        OutputView.printPriceAfterDiscount(bill);
    }

    private void inputDay() {
        int date = InputView.inputDate();
        reservationDay = new ReservationDay(date);
    }

    private void inputOrder() {
        String orderInput = InputView.inputOrder();
        order.takeOrder(orderInput.replace(" ", ""));
    }
}
