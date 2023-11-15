package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecemberCalendarTest {
    @Test
    @DisplayName("주중_주말_날짜_예외_테스트")
    void isWeekday_WeekendDate_ShouldReturnFalse() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertFalse(decemberCalendar.isWeekday(2));
    }

    @Test
    @DisplayName("주중_주중_날짜_테스트")
    void isWeekday_WeekdayDate_ShouldReturnTrue() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertTrue(decemberCalendar.isWeekday(4));
    }

    @Test
    @DisplayName("별표_날짜_예외_테스트")
    void isSpecialDay_NonSpecialDayDate_ShouldReturnFalse() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertFalse(decemberCalendar.isSpecialDay(20));
    }

    @Test
    @DisplayName("별표_날짜_테스트")
    void isSpecialDay_SpecialDayDate_ShouldReturnTrue() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertTrue(decemberCalendar.isSpecialDay(25));
    }
}
