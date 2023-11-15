package christmas.domain;

import christmas.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDayTest {

    @Test
    @DisplayName("날짜_유효값_입력_테스트")
    void reserveDay_ValidDayInput_ShouldNotThrowException() {
        ReservationDay reservationDay = new ReservationDay();
        String validDayInput = "10";

        assertDoesNotThrow(() -> reservationDay.reserveDay(validDayInput));
        assertEquals(10, reservationDay.getDay());
    }

    @Test
    @DisplayName("날짜_문자열_예외_테스트")
    void reserveDay_InvalidDayInput_ShouldThrowException() {
        ReservationDay reservationDay = new ReservationDay();
        String invalidDayInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reservationDay.reserveDay(invalidDayInput));
        assertEquals(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("날짜_범위밖_예외_테스트")
    void reserveDay_OutRangeInput_ShouldThrowException(){
        ReservationDay reservationDay = new ReservationDay();
        String invalidDayInput = "35";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reservationDay.reserveDay(invalidDayInput));
        assertEquals(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("날짜_디데이_할인_범위안_테스트")
    void dDayDiscountEventPeriod_DayBeforeOrEqualTo25_ShouldReturnTrue() {
        ReservationDay reservationDay = new ReservationDay();
        reservationDay.reserveDay("25");

        assertTrue(reservationDay.dDayDiscountEventPeriod());
    }

    @Test
    @DisplayName("날짜_디데이_할인_범위밖_테스트")
    void dDayDiscountEventPeriod_DayAfter25_ShouldReturnFalse() {
        ReservationDay reservationDay = new ReservationDay();
        reservationDay.reserveDay("26");

        assertFalse(reservationDay.dDayDiscountEventPeriod());
    }
}
