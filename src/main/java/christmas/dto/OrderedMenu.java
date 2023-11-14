package christmas.dto;

import christmas.enums.Menu;
import christmas.parser.Parser;

public class OrderedMenu {
    private Menu menu;
    private int count;

    public OrderedMenu(String menu, int count) {
        try {
            validateCount(count);
            Menu menuValue = Menu.findMenu(menu);

            this.menu = menuValue;
            this.count = count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateCount(int count) {
        if (count < 0)
            throw new IllegalArgumentException();
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
