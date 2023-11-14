package christmas.domain;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.OrderedMenu;
import christmas.enums.ErrorMessage;
import christmas.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderedMenu> orderDetails = new ArrayList<>();
    private static final String NON_PERMIT_SINGLE_MENU_TYPE = "beverage";

    public void takeOrder(String input) {
        List<String> eachOrder = Parser.inputToEachOrder(input);

        try {
            for (String orderInformation : eachOrder) {
                String[] menuInformation = Parser.inputToMenu(orderInformation);

                validDuplicateMenu(orderDetails, menuInformation[0]);
                validOrderFormat(menuInformation);
                int count = Parser.stringToIntPaser(menuInformation[1]);

                orderDetails.add(new OrderedMenu(menuInformation[0], count));
            }
            validOnlyBeverage();
        } catch (Exception e) {
            System.out.println(ErrorMessage.ORDER_ERROR_MESSAGE.getMessage());
            takeOrder(Console.readLine());
        }
    }

    private void validDuplicateMenu(List<OrderedMenu> orderDetails, String menuName) {
        for (OrderedMenu order : orderDetails) {
            if (order.getMenu().getMenuItem().getName().equals(menuName))
                throw new IllegalArgumentException();
        }
    }

    private void validOrderFormat(String[] menuInfo) {
        if (menuInfo.length != 2) throw new IllegalArgumentException();
    }

    private void validOnlyBeverage() {
        for (OrderedMenu order : orderDetails) {
            if (!order.getMenu().getMenuItem()
                    .getMenuType().equals(NON_PERMIT_SINGLE_MENU_TYPE)) return;
        }

        throw new IllegalArgumentException();
    }

    public String toString() {
        String output = "";
        for (OrderedMenu order : orderDetails) {
            output += (order.getMenu().getMenuItem().getName() + " " + order.getCount() + "개\n");
        }
        return output;
    }

    public List<OrderedMenu> getOrderDetails() {
        return orderDetails;
    }
}
