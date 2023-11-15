package christmas.domain;

import christmas.utils.ErrorMessage;
import christmas.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private static final String NON_PERMIT_SINGLE_MENU_TYPE = "beverage";
    private static final int MAXIMUM_QUANTITY = 20;

    private final Map<Menu, Integer> orderDetails = new HashMap<>();
    private int quantity = 0;

    public void takeOrder(String input) {
        List<String> eachOrderedMenu = Parser.inputToEachOrderedMenu(input);
        try {
            calculateMenuQuantity();

            eachOrderedMenu.forEach(menuInformation -> processOrderedMenu(menuInformation));
            validOnlyBeverage();
            validMaximumQuantity();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage());
        }
    }

    private void processOrderedMenu(String menuInformation) {
        String[] menuNameAndNumber = Parser.inputToMenu(menuInformation);
        String menuName = menuNameAndNumber[0];
        int menuNumber = Parser.stringToIntPaser(menuNameAndNumber[1]);
        Menu orderedMenu = Menu.findMenu(menuName);

        validDuplicateMenu(orderedMenu);
        validOrderFormat(menuNameAndNumber);
        orderDetails.put(orderedMenu, menuNumber);
    }

    private void calculateMenuQuantity() {
        for (int count : orderDetails.values()) {
            quantity += count;
        }
    }

    private void validMaximumQuantity() {
        if (quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage());
    }

    private void validDuplicateMenu(Menu orderedMenu) {
        if (orderDetails.containsKey(orderedMenu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validOrderFormat(String[] menuInfo) {
        if (menuInfo.length != 2) throw new IllegalArgumentException();
    }

    private void validOnlyBeverage() {
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            if (!menu.getMenuItem().getMenuType().equals(NON_PERMIT_SINGLE_MENU_TYPE)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            output.append(menu.getMenuItem().getName())
                    .append(" ")
                    .append(count)
                    .append("개\n");
        }
        return output.toString();
    }

    public Map<Menu, Integer> getOrderDetails() {
        return orderDetails;
    }
}
