package christmas.parser;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private final static String INPUT_TO_EACH_ORDER_REGEX = ",";
    private final static String EACH_ORDER_TO_PER_ORDER_REGEX = "-";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    public static int stringToIntPaser(String input) {
        if (input.isBlank()) throw new IllegalArgumentException();
        return Integer.parseInt(input);
    }

    public static List<String> inputToEachOrderedMenu(String input) {
        return Arrays.stream(input.split(INPUT_TO_EACH_ORDER_REGEX)).toList();
    }

    public static String[] inputToMenu(String input) {
        String[] menuInfo = input.split(EACH_ORDER_TO_PER_ORDER_REGEX);
        return menuInfo;
    }

    public static String BigDecimalToFormmatedString(BigDecimal price) {
        return DECIMAL_FORMAT.format(price);
    }
}
