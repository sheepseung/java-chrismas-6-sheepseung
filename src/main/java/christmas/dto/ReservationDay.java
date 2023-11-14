package christmas.dto;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.ErrorMessage;
import christmas.parser.Parser;

public class ReservationDay {
    private int day;

    public void reserveDay(String dayInput) {
        try {
            this.day = Parser.stringToIntPaser(dayInput);
            validateDay(day);
        }
        catch (Exception e){
            System.out.println(ErrorMessage.INPUT_DAY_ERROR_MESSAGE.getMessage());
            reserveDay(Console.readLine());
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
