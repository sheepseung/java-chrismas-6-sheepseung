package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.dto.ReservationDay;

public interface EventController {

    void dDayDiscountEvent(ReservationDay reservationDay, Bill bill);

    void weekDayDiscountEvent(ReservationDay reservationDay, Order order, Bill bill);
}
