package christmas.domain;

import christmas.enums.Menu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
    public Order(String input){

    }

    private List<Menu> appetizer = Stream.of(Menu.APPETIZER_TAPAS, Menu.APPETIZER_MUSHROOM_SOUP, Menu.APPETIZER_CAESAR_SALAD)
            .collect(Collectors.toList());
    private List<Menu> main = Stream.of(Menu.MAIN_T_BONE_STEAK, Menu.MAIN_BBQ_RIB, Menu.MAIN_CHRISTMAS_PASTA, Menu.MAIN_SEAFOOD_PASTA)
            .collect(Collectors.toList());
    private List<Menu> dessert = Stream.of(Menu.DESSERT_CHOCO_CAKE, Menu.DESSERT_ICE_CREAM)
            .collect(Collectors.toList());
    private List<Menu> beverage = Stream.of(Menu.BEVERAGE_CHAMPAGNE, Menu.BEVERAGE_RED_WINE, Menu.BEVERAGE_ZERO_COLA)
            .collect(Collectors.toList());
}
