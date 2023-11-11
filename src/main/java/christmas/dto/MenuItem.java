package christmas.dto;

public class MenuItem {
    private final String name;
    private final String menuType;

    public MenuItem(String name, String menuType) {
        this.name = name;
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public String getMenuType() {
        return menuType;
    }
}
