package christmas.domain;

import christmas.dao.MenuItem;

import java.math.BigDecimal;

public enum Menu {
    APPETIZER_MUSHROOM_SOUP(new MenuItem("양송이수프", "appetizer"), new BigDecimal("6000")),
    APPETIZER_TAPAS(new MenuItem("타파스", "appetizer"), new BigDecimal("5500")),
    APPETIZER_CAESAR_SALAD(new MenuItem("시저샐러드", "appetizer"), new BigDecimal("8000")),

    MAIN_T_BONE_STEAK(new MenuItem("티본스테이크", "main"), new BigDecimal("55000")),
    MAIN_BBQ_RIB(new MenuItem("바비큐립", "main"), new BigDecimal("54000")),
    MAIN_SEAFOOD_PASTA(new MenuItem("해산물파스타", "main"), new BigDecimal("35000")),
    MAIN_CHRISTMAS_PASTA(new MenuItem("크리스마스파스타", "main"), new BigDecimal("25000")),

    DESSERT_CHOCO_CAKE(new MenuItem("초코케이크", "dessert"), new BigDecimal("15000")),
    DESSERT_ICE_CREAM(new MenuItem("아이스크림", "dessert"), new BigDecimal("5000")),

    BEVERAGE_ZERO_COLA(new MenuItem("제로콜라", "beverage"), new BigDecimal("3000")),
    BEVERAGE_RED_WINE(new MenuItem("레드와인", "beverage"), new BigDecimal("60000")),
    BEVERAGE_CHAMPAGNE(new MenuItem("샴페인", "beverage"), new BigDecimal("25000"));


    private final MenuItem menuItem;
    private final BigDecimal price;

    Menu(MenuItem menuItem, BigDecimal price) {
        this.menuItem = menuItem;
        this.price = price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Menu findMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menuName.equals(menu.getMenuItem().getName())) {
                return menu;
            }
        }
        throw new IllegalArgumentException();
    }
}
