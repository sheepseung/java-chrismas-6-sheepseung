package christmas.domain;

import christmas.dto.OrderedMenu;
import christmas.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final static String INPUT_TO_EACH_ORDER_REGEX = ",";
    private final static String EACH_ORDER_TO_PER_ORDER_REGEX = "-";

    private final List<OrderedMenu> orderDetails = new ArrayList<>();

    public Order(String input) {
        takeOrder(input);
    }

    private void takeOrder(String input) {
        List<String> eachOrder = Arrays.stream(input.split(INPUT_TO_EACH_ORDER_REGEX)).toList();

        for (String orderInfo : eachOrder) {
            String[] menuInfo = orderInfo.split(EACH_ORDER_TO_PER_ORDER_REGEX);
            validFormat(menuInfo);

            validDuplicateMenu(orderDetails, menuInfo[0]);
            OrderedMenu order = new OrderedMenu(menuInfo[0], menuInfo[1]);
            orderDetails.add(order);
        }
    }

    private void validFormat(String[] menuInfo){
        if(menuInfo.length != 2) throw new IllegalArgumentException(ErrorMessage.ORDER_DIFFERENT_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private void validDuplicateMenu(List<OrderedMenu> orderDetails, String menuName){
        for(OrderedMenu order : orderDetails){
            if(order.getMenu().getName().equals(menuName)) throw new IllegalArgumentException(ErrorMessage.ORDER_DUPLICATE_MENU_ERROR_MESSAGE.getMessage());
        }
    }

    public String toString() {
        String output = "";
        for (OrderedMenu order : orderDetails) {
            output += (order.getMenu().getName() + " " + order.getCount() + "개\n");
        }
        return output;
    }
}
