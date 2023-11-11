package christmas.domain;

import christmas.dto.OrderedMenu;

import java.math.BigDecimal;

public class Bill {
    private static final int MINIMUM_AMOUNT = 10000;
    private static final int MAXIMUM_QUANTITY = 20;

    private final Order order;
    private BigDecimal totalPrice = new BigDecimal(0);
    private int quantity = 0;

    public Bill(Order order){
        this.order = order;
        calculateTotalPrice();
        calculateMenuQuantity();

        validMinimumAmount();
        validMaximumQuantity();
    }

    private void calculateTotalPrice(){
        for(OrderedMenu orderedMenu : order.getOrderDetails()){
            totalPrice.add(orderedMenu.getMenu().getPrice());
        }
    }

    private void calculateMenuQuantity(){
        for(OrderedMenu orderedMenu : order.getOrderDetails()){
            quantity += orderedMenu.getCount();
        }
    }

    private void validMinimumAmount(){
        if(totalPrice.compareTo(new BigDecimal(MINIMUM_AMOUNT)) == -1)
            throw new IllegalArgumentException("[ERROR] : 최소 주문 금액을 확인해주세요.");
    }

    private void validMaximumQuantity(){
        if(quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException("[ERROR] : 최대 20개 까지 주문 가능합니다.");
    }
}
