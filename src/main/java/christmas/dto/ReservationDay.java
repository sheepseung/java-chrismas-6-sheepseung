package christmas.dto;

import christmas.enums.ErrorMessage;

public class ReservationDay {
    private final int day;

    public ReservationDay(int day) {
        this.day = day;
        validateDay();
    }

    private void validateDay() {
        if (day > 31 || day < 1)
            throw new IllegalArgumentException(ErrorMessage.INPUT_OVER_RANGE_ERROR_MESSAGE.getMessage());
    }

    public int getDay() {
        return day;
    }

    public boolean dDayDiscountEventPeriod() {
        if (day <= 25) return true;
        return false;
    }
}
