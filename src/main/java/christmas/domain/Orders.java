package christmas.domain;

import christmas.enums.Menu;

import java.util.Arrays;
import java.util.List;

public class Orders {
    private List<Order> orders;

    public void takeOrder(String input){
        List<String> eachOrder = Arrays.stream(input.split(",")).toList();

        for(String orderInfo : eachOrder){
            String[] menuInfo = orderInfo.split("-");

            String menuName = menuInfo[0];
            Menu menu = Menu.findMenu(menuName);
            int menuNumber = Integer.parseInt(menuInfo[1]);

            Order order = new Order(menu, menuNumber);
            orders.add(order);
        }
    }

}
