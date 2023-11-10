package christmas.enums;

import java.math.BigDecimal;

public enum Menu {
    APPETIZER_MUSHROOM_SOUP("양송이수프", new BigDecimal("6000")),
    APPETIZER_TAPAS("타파스", new BigDecimal("5500")),
    APPETIZER_CAESAR_SALAD("시저샐러드", new BigDecimal("8000")),

    MAIN_T_BONE_STEAK("티본스테이크", new BigDecimal("55000")),
    MAIN_BBQ_RIB("바비큐립", new BigDecimal("54000")),
    MAIN_SEAFOOD_PASTA("해산물파스타", new BigDecimal("35000")),
    MAIN_CHRISTMAS_PASTA("크리스마스파스타", new BigDecimal("25000")),

    DESSERT_CHOCO_CAKE("초코케이크", new BigDecimal("15000")),
    DESSERT_ICE_CREAM("아이스크림", new BigDecimal("5000")),

    BEVERAGE_ZERO_COLA("제로콜라", new BigDecimal("3000")),
    BEVERAGE_RED_WINE("레드와인", new BigDecimal("60000")),
    BEVERAGE_CHAMPAGNE("샴페인", new BigDecimal("25000"));

    private final String name;
    private final BigDecimal price;

    Menu(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Menu findMenu(String menuName){
        for (Menu menu : Menu.values()) {
            if (menuName.equals(menu.getName())) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.ORDER_NON_EXISTENT_MENU_ERROR_MESSAGE.getMessage());
    }
}
