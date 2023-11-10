package christmas.domain;

import christmas.enums.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private List<Order> orderDetails = new ArrayList<>();

    public Orders(String input){
        takeOrder(input);
    }

    private void takeOrder(String input){
        List<String> eachOrder = Arrays.stream(input.split(",")).toList();

        for(String orderInfo : eachOrder){
            String[] menuInfo = orderInfo.split("-");

            String menuName = menuInfo[0];
            Menu menu = Menu.findMenu(menuName);
            int menuNumber = Integer.parseInt(menuInfo[1]);

            Order order = new Order(menu, menuNumber);
            orderDetails.add(order);
        }
    }

    public String toString(){
        String output = "";
        for(Order order : orderDetails){
            output += (order.getMenu().getName() + " " + order.getCount() + "개\n");
        }

        return output;
    }
}
