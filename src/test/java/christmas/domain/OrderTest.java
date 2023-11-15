package christmas.domain;

import christmas.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    String validInput = "티본스테이크-2,양송이수프-2";
    @Test
    @DisplayName("주문_유효값_입력_테스트")
    void takeOrder_ValidInput_ShouldNotThrowException() {
        Order order = new Order();
        assertDoesNotThrow(() -> order.takeOrder(validInput));
    }

    @Test
    @DisplayName("주문_중복_예외_테스트")
    void takeOrder_DuplicateMenu_ShouldThrowException() {
        Order order = new Order();
        String duplicateMenuInput = "티본스테이크-2,티본스테이크-2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> order.takeOrder(duplicateMenuInput));
        assertEquals(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("주문_입력형식_예외_테스트")
    void takeOrder_InvalidOrderFormat_ShouldThrowException() {
        Order order = new Order();
        String invalidFormatInput = "티본스테이크+2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> order.takeOrder(invalidFormatInput));
        assertEquals(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("주문_개수초과_예외_테스트")
    void takeOrder_ExceedMaximumQuantity_ShouldThrowException() {
        Order order = new Order();
        String exceedQuantityInput = "티본스테이크-20,양송이수프-10";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> order.takeOrder(exceedQuantityInput));
        assertEquals(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("주문_음료_예외_테스트")
    void takeOrder_OnlyBeverage_ValidInput_ShouldNotThrowException() {
        Order order = new Order();
        String onlyBeverageInput = "제로콜라-10";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> order.takeOrder(onlyBeverageInput));
        assertEquals(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("주문_공백_예외_테스트")
    void toString_OrderDetailsEmpty_ShouldReturnEmptyString() {
        Order order = new Order();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> order.takeOrder(""));
        assertEquals(ErrorMessage.INPUT_ORDER_ERROR_MESSAGE.getMessage(), exception.getMessage());
        assertEquals("", order.toString());
    }

    @Test
    @DisplayName("주문_내역_출력_테스트")
    void getOrderDetails_OrderDetailsNotEmpty_ShouldReturnOrderDetails() {
        Order order = new Order();
        order.takeOrder(validInput);

        Map<Menu, Integer> expectedOrderDetails = new HashMap<>();
        expectedOrderDetails.put(Menu.findMenu("티본스테이크"), 2);
        expectedOrderDetails.put(Menu.findMenu("양송이수프"), 2);

        assertEquals(expectedOrderDetails, order.getOrderDetails());
    }
}
