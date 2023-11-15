package christmas.domain.validator;

import christmas.domain.Menu;
import christmas.utils.ErrorMessage;

import java.util.Map;

public class OrderValidator {
    private static final String NON_PERMIT_SINGLE_MENU_TYPE = "beverage";
    private static final int MAXIMUM_QUANTITY = 20;

    public static void validateMaximumQuantity(int quantity) {
        if (quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage());
    }

    public static void validateDuplicateMenu(Map<Menu, Integer> orderDetails, Menu orderedMenu) {
        if (orderDetails.containsKey(orderedMenu)) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateOrderFormat(String[] menuInfo) {
        if (menuInfo.length != 2) throw new IllegalArgumentException();
    }

    public static void validateOnlyBeverage(Map<Menu, Integer> orderDetails) {
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            if (!menu.getMenuItem().getMenuType().equals(NON_PERMIT_SINGLE_MENU_TYPE)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
