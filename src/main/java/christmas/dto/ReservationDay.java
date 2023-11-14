package christmas.dto;

import christmas.enums.ErrorMessage;
import christmas.parser.Parser;

public class ReservationDay {
    private final int day;

    public ReservationDay(String dayInput) {
        try {
            this.day = Parser.stringToIntPaser(dayInput);
            validateDay(day);
        }
        catch (Exception e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDay(int day) {
        if (day > 31 || day < 1)
            throw new IllegalArgumentException();
    }

    public int getDay() {
        return day;
    }

    public boolean dDayDiscountEventPeriod() {
        if (day <= 25) return true;
        return false;
    }
}
