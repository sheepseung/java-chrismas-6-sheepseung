package christmas.domain;

import christmas.dto.OrderedMenu;

import java.math.BigDecimal;

public class Bill {
    private static final int MINIMUM_AMOUNT = 10000;

    private final Order order;
    private BigDecimal totalPrice;

    public Bill(Order order){
        this.order = order;
        calculateTotalPrice();
        validMinimumAmount();
    }

    private void calculateTotalPrice(){
        for(OrderedMenu orderedMenu : order.getOrderDetails()){
            totalPrice.add(orderedMenu.getMenu().getPrice());
        }
    }

    private void validMinimumAmount(){
        if(totalPrice.compareTo(new BigDecimal(MINIMUM_AMOUNT)) == -1){
            throw new IllegalArgumentException("[ERROR] : 최소 주문 금액을 확인해주세요.");
        }
    }

}
