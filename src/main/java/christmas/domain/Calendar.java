package christmas.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calendar {
    private List<Integer> weekends = Stream.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
            .collect(Collectors.toList());
    private List<Integer> starDay = Stream.of(3, 10, 17, 24, 25, 31)
            .collect(Collectors.toList());



}
