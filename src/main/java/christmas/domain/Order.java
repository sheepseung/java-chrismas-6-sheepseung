package christmas.domain;

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

        for (String orderInfo : eachOrder) {
            String[] menuInfo = Parser.inputToMenu(orderInfo);

            validDuplicateMenu(orderDetails, menuInfo[0]);
            orderDetails.add(new OrderedMenu(menuInfo[0], menuInfo[1]));
        }

        validOnlyBeverage();
    }

    private void validDuplicateMenu(List<OrderedMenu> orderDetails, String menuName) {
        for (OrderedMenu order : orderDetails) {
            if (order.getMenu().getMenuItem().getName().equals(menuName))
                throw new IllegalArgumentException(ErrorMessage.ORDER_DUPLICATE_MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private void validOnlyBeverage() {
        for (OrderedMenu order : orderDetails) {
            if (!order.getMenu().getMenuItem()
                    .getMenuType().equals(NON_PERMIT_SINGLE_MENU_TYPE)) return;
        }

        throw new IllegalArgumentException(ErrorMessage.ORDER_ONLY_BEVERAGE_ERROR_MESSAGE.getMessage());
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
