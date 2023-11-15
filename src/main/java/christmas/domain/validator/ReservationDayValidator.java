package christmas.domain.validator;

public class ReservationDayValidator {

    public static void validateDay(int day) {
        if (day > 31 || day < 1)
            throw new IllegalArgumentException();
    }
}
