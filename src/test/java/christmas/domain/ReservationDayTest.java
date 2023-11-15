package christmas.domain;

import christmas.utils.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDayTest {

    @Test
    void reserveDay_ValidDayInput_ShouldNotThrowException() {
        ReservationDay reservationDay = new ReservationDay();
        String validDayInput = "10";

        assertDoesNotThrow(() -> reservationDay.reserveDay(validDayInput));
        assertEquals(10, reservationDay.getDay());
    }

    @Test
    void reserveDay_InvalidDayInput_ShouldThrowException() {
        ReservationDay reservationDay = new ReservationDay();
        String invalidDayInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reservationDay.reserveDay(invalidDayInput));
        assertEquals(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    void reserveDay_OutRangeInput_ShouldThrowException(){
        ReservationDay reservationDay = new ReservationDay();
        String invalidDayInput = "35";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reservationDay.reserveDay(invalidDayInput));
        assertEquals(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    void dDayDiscountEventPeriod_DayBeforeOrEqualTo25_ShouldReturnTrue() {
        ReservationDay reservationDay = new ReservationDay();
        reservationDay.reserveDay("25");

        assertTrue(reservationDay.dDayDiscountEventPeriod());
    }

    @Test
    void dDayDiscountEventPeriod_DayAfter25_ShouldReturnFalse() {
        ReservationDay reservationDay = new ReservationDay();
        reservationDay.reserveDay("26");

        assertFalse(reservationDay.dDayDiscountEventPeriod());
    }
}
