package christmas.domain;

import christmas.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private final static String INPUT_TO_EACH_ORDER_REGEX = ",";
    private final static String EACH_ORDER_TO_PER_ORDER_REGEX = "-";

    private final List<Order> orderDetails = new ArrayList<>();


    public Orders(String input) {
        takeOrder(input);
    }

    private void takeOrder(String input) {
        List<String> eachOrder = Arrays.stream(input.split(INPUT_TO_EACH_ORDER_REGEX)).toList();

        for (String orderInfo : eachOrder) {
            String[] menuInfo = orderInfo.split(EACH_ORDER_TO_PER_ORDER_REGEX);
            validFormat(menuInfo);

            Order order = new Order(menuInfo[0], menuInfo[1]);
            orderDetails.add(order);
        }
    }

    private void validFormat(String[] menuInfo){
        if(menuInfo.length != 2) throw new IllegalArgumentException(ErrorMessage.ORDER_DIFFERENT_FORMAT_ERROR_MESSAGE.getMessage());
    }

    public String toString() {
        String output = "";
        for (Order order : orderDetails) {
            output += (order.getMenu().getName() + " " + order.getCount() + "개\n");
        }
        return output;
    }
}
