package christmas.domain;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.ErrorMessage;
import christmas.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderDetails = new HashMap<>();
    private static final String NON_PERMIT_SINGLE_MENU_TYPE = "beverage";

    public void takeOrder(String input) {
        List<String> eachOrderedMenu = Parser.inputToEachOrderedMenu(input);

        try {
            for (String menuInformation : eachOrderedMenu) {
                String[] menuNameAndNumber = Parser.inputToMenu(menuInformation);

                String menuName = menuNameAndNumber[0];
                int menuNumber = Parser.stringToIntPaser(menuNameAndNumber[1]);
                Menu orderedMenu = Menu.findMenu(menuName);

                validDuplicateMenu(orderedMenu);
                validOrderFormat(menuNameAndNumber);
                orderDetails.put(orderedMenu, menuNumber);
            }
            validOnlyBeverage();
        } catch (Exception e) {
            System.out.println(ErrorMessage.ORDER_ERROR_MESSAGE.getMessage());
            takeOrder(Console.readLine());
        }
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
