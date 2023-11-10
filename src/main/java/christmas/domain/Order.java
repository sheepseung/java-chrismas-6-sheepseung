package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.parser.Parser;

public class Order {
    private Menu menu;
    private int count;

    public Order(String menu, String count) {
        int countValue = Parser.stringToIntPaser(count);
        Menu menuValue = Menu.findMenu(menu);

        validateCount(countValue);

        this.menu = menuValue;
        this.count = countValue;
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
