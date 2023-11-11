package christmas.domain;

import christmas.dto.OrderedMenu;

import java.math.BigDecimal;

public class Bill {
    private final Order order;
    private BigDecimal totalPrice;

    public Bill(Order order){
        this.order = order;
        calculateTotalPrice();
    }

    private void calculateTotalPrice(){
        for(OrderedMenu orderedMenu : order.getOrderDetails()){
            totalPrice.add(orderedMenu.getMenu().getPrice());
        }
    }
}
