package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.enums.Menu;

public class Order {
    private Menu menu;
    private int count;

    public Order(Menu menu, int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    private void validateCount(int count){
        if(count < 0) throw new IllegalArgumentException(ErrorMessage.ORDER_UNDER_ZERO_NUMBER_ERROR_MESSAGE.getMessage());
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
