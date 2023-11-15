package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecemberCalendarTest {
    @Test
    void isWeekday_WeekendDate_ShouldReturnFalse() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertFalse(decemberCalendar.isWeekday(2));
    }

    @Test
    void isWeekday_WeekdayDate_ShouldReturnTrue() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertTrue(decemberCalendar.isWeekday(4));
    }

    @Test
    void isSpecialDay_NonSpecialDayDate_ShouldReturnFalse() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertFalse(decemberCalendar.isSpecialDay(20));
    }
    @Test
    void isSpecialDay_SpecialDayDate_ShouldReturnTrue() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        assertTrue(decemberCalendar.isSpecialDay(25));
    }
}
