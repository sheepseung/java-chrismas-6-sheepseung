package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.view.EventView;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private ReservationDay reservationDay;
    private Bill bill;

    private final Order order;
    private final EventController eventController;

    public PlannerController(EventController eventController) {
        this.eventController = eventController;
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
            EventView.printPriceBeforeDiscount(bill);

            eventController.applyEvent(reservationDay, order, bill);
            eventController.showEventDiscountDetails();

            EventView.printPriceAfterDiscount(bill);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void inputDay() {
        String dayInput = InputView.inputDate();
        reservationDay = new ReservationDay(dayInput);
    }

    private void inputOrder() {
        String orderInput = InputView.inputOrder();
        order.takeOrder(orderInput.replace(" ", ""));
    }
}
