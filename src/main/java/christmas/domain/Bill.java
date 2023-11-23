package christmas.domain;

import java.math.BigDecimal;
import java.util.Map;

public class Bill {
    private final Map<Menu, Integer> orderDetails;

    private BigDecimal totalPrice = new BigDecimal(0);

    public Bill(Order order) {
        this.orderDetails = order.getOrderDetails();
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            BigDecimal price = menu.getPrice().multiply(BigDecimal.valueOf(count));
            totalPrice = totalPrice.add(price);
        }
    }

    public void discountPrice(BigDecimal discountValue) {
        totalPrice = totalPrice.subtract(discountValue);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
