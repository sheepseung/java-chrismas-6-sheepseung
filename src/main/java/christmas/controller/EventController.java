package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.dto.ReservationDay;

public interface EventController {

    void dDayDiscountEvent(ReservationDay reservationDay, Bill bill);

    void weekdayDiscountEvent(ReservationDay reservationDay, Order order, Bill bill);

    void weekendDiscountEvent(ReservationDay reservationDay, Order order, Bill bill);

    void showEventDiscountDetails();
}
