package christmas.Parser;

import christmas.Message.ErrorMessage;

public class Parser {
    public static int stringToIntPaser(String input) {
        if (input.isBlank()) throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_ERROR_MESSAGE.getMessage());
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER_ERROR_MESSAGE.getMessage());
        }
    }
}
