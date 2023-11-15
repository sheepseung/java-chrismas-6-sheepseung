package christmas.domain;

import java.math.BigDecimal;

public enum Badge {
    SANTA_BADGE("산타", new BigDecimal(20000)),
    TREE_BADGE("트리", new BigDecimal(10000)),
    STAR_BADGE("별", new BigDecimal(5000));

    private final String name;
    private final BigDecimal standardAmount;

    Badge(String name, BigDecimal standardAmount) {
        this.name = name;
        this.standardAmount = standardAmount;
    }

    public String getName() {
        if(this == null) return "";
        return name;
    }

    public static Badge getBadge(BigDecimal totalBenefit) {
        if (totalBenefit.compareTo(SANTA_BADGE.standardAmount) == 1) {
            return SANTA_BADGE;
        }
        if (totalBenefit.compareTo(TREE_BADGE.standardAmount) == 1) {
            return TREE_BADGE;
        }
        if (totalBenefit.compareTo(STAR_BADGE.standardAmount) == 1) {
            return STAR_BADGE;
        }
        return null;
    }
}
