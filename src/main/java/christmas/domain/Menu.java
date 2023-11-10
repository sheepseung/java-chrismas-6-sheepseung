package christmas.domain;

import christmas.enums.Food;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private List<Food> appetizer = Stream.of(Food.APPETIZER_TAPAS, Food.APPETIZER_MUSHROOM_SOUP, Food.APPETIZER_CAESAR_SALAD)
            .collect(Collectors.toList());
    private List<Food> main = Stream.of(Food.MAIN_T_BONE_STEAK, Food.MAIN_BBQ_RIB, Food.MAIN_CHRISTMAS_PASTA, Food.MAIN_SEAFOOD_PASTA)
            .collect(Collectors.toList());
    private List<Food> dessert = Stream.of(Food.DESSERT_CHOCO_CAKE, Food.DESSERT_ICE_CREAM)
            .collect(Collectors.toList());
    private List<Food> beverage = Stream.of(Food.BEVERAGE_CHAMPAGNE, Food.BEVERAGE_RED_WINE, Food.BEVERAGE_ZERO_COLA)
            .collect(Collectors.toList());
}
