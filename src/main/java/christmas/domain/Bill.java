package christmas.domain;

import christmas.dto.OrderedMenu;
import christmas.enums.ErrorMessage;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Bill {
    private static final int MINIMUM_AMOUNT = 10000;
    private static final int MAXIMUM_QUANTITY = 20;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

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
            BigDecimal price = (orderedMenu.getMenu().getPrice())
                    .multiply(BigDecimal.valueOf(orderedMenu.getCount()));
            totalPrice = totalPrice.add(price);
        }
    }

    private void calculateMenuQuantity(){
        for(OrderedMenu orderedMenu : order.getOrderDetails()){
            quantity += orderedMenu.getCount();
        }
    }

    private void validMinimumAmount(){
        if(totalPrice.compareTo(new BigDecimal(MINIMUM_AMOUNT)) != 1)
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_ORDER_AMOUNT_ERROR_MESSAGE.getMessage());
    }

    private void validMaximumQuantity(){
        if(quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException(ErrorMessage.MAXIMUM_ORDER_QUANTITY_ERROR_MESSAGE.getMessage());
    }

    public String getTotalPrice(){
        return DECIMAL_FORMAT.format(totalPrice);
    }
}
