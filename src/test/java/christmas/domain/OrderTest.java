package christmas.domain;

import christmas.dto.OrderedMenu;
import christmas.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    Order testOrder = new Order("양송이수프-1,티본스테이크-2,초코케이크-3");

    @Test
    public void testTakeOrderAndToString() {
        List<OrderedMenu> orderDetails = testOrder.getOrderDetails();
        assertEquals(3, orderDetails.size());

        String expectedOutput = "양송이수프 1개\n티본스테이크 2개\n초코케이크 3개\n";
        assertEquals(expectedOutput, testOrder.toString());
    }

    @Test
    public void testValidDuplicateMenu() {
        String input = "양송이수프-1,바비큐립-2,양송이수프-3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Order(input));

        assertEquals(ErrorMessage.ORDER_DUPLICATE_MENU_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    public void testValidOnlyBeverage() {
        String input = "레드와인-1,샴페인-2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Order(input));

        assertEquals(ErrorMessage.ORDER_ONLY_BEVERAGE_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }
}