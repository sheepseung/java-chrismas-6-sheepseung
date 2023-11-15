package christmas.domain;

import christmas.utils.ErrorMessage;
import christmas.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.domain.validator.OrderValidator.*;

public class Order {
    private final Map<Menu, Integer> orderDetails = new HashMap<>();
    private int quantity = 0;

    public void takeOrder(String input) {
        List<String> eachOrderedMenu = Parser.inputToEachOrderedMenu(input);
        try {
            eachOrderedMenu.forEach(menuInformation -> processOrderedMenu(menuInformation));

            calculateMenuQuantity();
            validateOnlyBeverage(orderDetails);
            validateMaximumQuantity(quantity);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage());
        }
    }

    private void processOrderedMenu(String menuInformation) {
        String[] menuNameAndNumber = Parser.inputToMenu(menuInformation);
        String menuName = menuNameAndNumber[0];
        int menuNumber = Parser.stringToIntPaser(menuNameAndNumber[1]);
        Menu orderedMenu = Menu.findMenu(menuName);

        validateDuplicateMenu(orderDetails ,orderedMenu);
        validateOrderFormat(menuNameAndNumber);
        orderDetails.put(orderedMenu, menuNumber);
    }

    private void calculateMenuQuantity() {
        for (int count : orderDetails.values()) {
            quantity += count;
        }
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
