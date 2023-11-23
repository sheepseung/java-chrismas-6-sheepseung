package christmas.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DecemberCalendar {
    private final List<Integer> weekdays = Stream.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)
            .collect(Collectors.toList());
    private final List<Integer> weekends = Stream.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
            .collect(Collectors.toList());
    private final List<Integer> specialDays = Stream.of(3, 10, 17, 24, 25, 31)
            .collect(Collectors.toList());

    public boolean isWeekday(int day) {
        if (weekdays.contains(day)) return true;
        return false;
    }

    public boolean isWeekend(int day) {
        if (weekends.contains(day)) return true;
        return false;
    }

    public boolean isSpecialDay(int day) {
        if (specialDays.contains(day)) return true;
        return false;
    }
}
