package christmas.domain;

import christmas.domain.validator.ReservationDayValidator;
import christmas.utils.ErrorMessage;
import christmas.parser.Parser;

public class ReservationDay {
    private int day;

    public void reserveDay(String dayInput) {
        try {
            this.day = Parser.stringToIntPaser(dayInput);
            ReservationDayValidator.validateDay(day);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage());
        }
    }

    public int getDay() {
        return day;
    }

    public boolean dDayDiscountEventPeriod() {
        if (day <= 25) return true;
        return false;
    }
}
