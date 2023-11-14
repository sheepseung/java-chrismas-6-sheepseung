package christmas.domain;

import christmas.dto.OrderedMenu;
import christmas.enums.ErrorMessage;

import java.math.BigDecimal;

public class Bill {
    private static final int MAXIMUM_QUANTITY = 20;

    private final Order order;
    private BigDecimal totalPrice = new BigDecimal(0);
    private int quantity = 0;

    public Bill(Order order) {
        this.order = order;
        calculateTotalPrice();
        calculateMenuQuantity();
        try {
            validMaximumQuantity();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateTotalPrice() {
        for (OrderedMenu orderedMenu : order.getOrderDetails()) {
            BigDecimal price = (orderedMenu.getMenu().getPrice())
                    .multiply(BigDecimal.valueOf(orderedMenu.getCount()));
            totalPrice = totalPrice.add(price);
        }
    }

    private void calculateMenuQuantity() {
        for (OrderedMenu orderedMenu : order.getOrderDetails()) {
            quantity += orderedMenu.getCount();
        }
    }

    private void validMaximumQuantity() {
        if (quantity > MAXIMUM_QUANTITY)
            throw new IllegalArgumentException(ErrorMessage.MAXIMUM_ORDER_QUANTITY_ERROR_MESSAGE.getMessage());
    }

    public void discountPrice(BigDecimal discountValue) {
        totalPrice = totalPrice.subtract(discountValue);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
