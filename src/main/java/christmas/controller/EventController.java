package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.domain.ReservationDay;

import java.math.BigDecimal;

public interface EventController {

    void applyEvent(ReservationDay day, Order order, Bill bill);

    void showEventDiscountDetails(Bill bill);

    void presentEvent(Bill bill);

    void dDayDiscountEvent(ReservationDay reservationDay, Bill bill);

    void weekdayDiscountEvent(ReservationDay day, Bill bill);

    void weekendDiscountEvent(ReservationDay day, Bill bill);

    void specialDayDiscountEvent(ReservationDay day, Bill bill);

    void badgeEvent(BigDecimal totalBenefitAmount);
}
