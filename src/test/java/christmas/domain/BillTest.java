package christmas.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {
    Order testOrder = new Order();

    @Test
    public void testBillTotalPriceCalculation() {
        testOrder.takeOrder("양송이수프-1,티본스테이크-2,초코케이크-3");
        Bill bill = new Bill(testOrder);

        BigDecimal expectedTotalPrice = BigDecimal
                .valueOf(1).multiply(Menu.APPETIZER_MUSHROOM_SOUP.getPrice())
                .add(BigDecimal.valueOf(2).multiply(Menu.MAIN_T_BONE_STEAK.getPrice()))
                .add(BigDecimal.valueOf(3).multiply(Menu.DESSERT_CHOCO_CAKE.getPrice()));

        assertEquals(expectedTotalPrice, bill.getTotalPrice());
    }

    @Test
    public void testBillMaximumQuantityValidation() {
        testOrder.takeOrder("양송이수프-5"); //30,000원
        Bill bill = new Bill(testOrder);
        bill.discountPrice(new BigDecimal(10000));  //30,000 - 10,000 원

        assertEquals(bill.getTotalPrice(), new BigDecimal(20000));
    }
}
