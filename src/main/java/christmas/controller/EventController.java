package christmas.controller;

import christmas.domain.Bill;
import christmas.dto.ReservationDay;

public interface EventController {

    void dDayDiscountEvent(ReservationDay reservationDay, Bill bill);
}
