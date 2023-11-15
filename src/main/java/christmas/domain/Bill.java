package christmas.domain;

import christmas.enums.ErrorMessage;

import java.math.BigDecimal;
import java.util.Map;

public class Bill {
    private static final int MAXIMUM_QUANTITY = 20;
    private final Map<Menu, Integer> orderDetails;

    private BigDecimal totalPrice = new BigDecimal(0);
    private int quantity = 0;

    public Bill(Order order) {
        this.orderDetails = order.getOrderDetails();
        calculateTotalPrice();
        calculateMenuQuantity();
        try {
            validMaximumQuantity();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateTotalPrice() {
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            BigDecimal price = menu.getPrice().multiply(BigDecimal.valueOf(count));
            totalPrice = totalPrice.add(price);
        }
    }

    private void calculateMenuQuantity() {
        for (int count : orderDetails.values()) {
            quantity += count;
        }
    }

    private void validMaximumQuantity() {
        if (quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getMessage());
    }

    public void discountPrice(BigDecimal discountValue) {
        totalPrice = totalPrice.subtract(discountValue);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
