package christmas.parser;

import christmas.enums.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private final static String INPUT_TO_EACH_ORDER_REGEX = ",";
    private final static String EACH_ORDER_TO_PER_ORDER_REGEX = "-";

    public static int stringToIntPaser(String input) {
        if (input.isBlank()) throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_ERROR_MESSAGE.getMessage());

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER_ERROR_MESSAGE.getMessage());
        }
    }

    public static List<String> inputToEachOrder(String input) {
        return Arrays.stream(input.split(INPUT_TO_EACH_ORDER_REGEX)).toList();
    }

    public static String[] inputToMenu(String input) {
        String[] menuInfo = input.split(EACH_ORDER_TO_PER_ORDER_REGEX);

        if (menuInfo.length != 2)
            throw new IllegalArgumentException(ErrorMessage.ORDER_DIFFERENT_FORMAT_ERROR_MESSAGE.getMessage());

        return menuInfo;
    }
}
