package christmas.dto;

import christmas.enums.Menu;
import christmas.parser.Parser;

public class OrderedMenu {
    private Menu menu;
    private int count;

    public OrderedMenu(String menu, String count) {
        try {
            int countValue = Parser.stringToIntPaser(count);
            validateCount(countValue);
            Menu menuValue = Menu.findMenu(menu);

            this.menu = menuValue;
            this.count = countValue;
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
