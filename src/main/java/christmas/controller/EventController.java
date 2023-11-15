package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.domain.ReservationDay;

public interface EventController {

    void applyEvent(ReservationDay day, Order order, Bill bill);

    void showEventDiscountDetails(Bill bill);
}
