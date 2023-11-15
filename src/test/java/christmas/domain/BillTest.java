//package christmas.domain;
//
//import christmas.enums.ErrorMessage;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BillTest {
//    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
//
//    Order testOrder = new Order();
//
//    @Test
//    public void testBillTotalPriceCalculation() {
//        testOrder.takeOrder("양송이수프-1,티본스테이크-2,초코케이크-3");
//        Bill bill = new Bill(testOrder);
//
//        BigDecimal expectedTotalPrice = BigDecimal
//                .valueOf(1).multiply(Menu.APPETIZER_MUSHROOM_SOUP.getPrice())
//                .add(BigDecimal.valueOf(2).multiply(Menu.MAIN_T_BONE_STEAK.getPrice()))
//                .add(BigDecimal.valueOf(3).multiply(Menu.DESSERT_CHOCO_CAKE.getPrice()));
//
//        assertEquals(DECIMAL_FORMAT.format(expectedTotalPrice), bill.getTotalPrice());
//    }
//
//    @Test
//    public void testBillMinimumAmountValidation() {
//        testOrder.takeOrder("양송이수프-1");
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
//                -> new Bill(testOrder));
//
//        assertEquals(ErrorMessage.ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
//    }
//
//    @Test
//    public void testBillMaximumQuantityValidation() {
//        testOrder.takeOrder("양송이수프-10,티본스테이크-20");
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Bill(testOrder));
//
//        assertEquals(ErrorMessage.ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
//    }
//}
