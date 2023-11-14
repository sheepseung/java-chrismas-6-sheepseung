package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.dto.ReservationDay;
import christmas.view.EventView;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.math.BigDecimal;

public class PlannerController {
    private ReservationDay reservationDay;
    private Order order = new Order();
    private Bill bill;
    private final EventController eventController;

    private final BigDecimal EVENT_APPLY_STANDARD_PRICE = new BigDecimal(10000);
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
        EventView.printPriceBeforeDiscount(bill);

        if(bill.getTotalPrice().compareTo(EVENT_APPLY_STANDARD_PRICE) >= 0) {
            eventController.applyEvent(reservationDay, order, bill);
            eventController.showEventDiscountDetails();
        }

        EventView.printPriceAfterDiscount(bill);
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
