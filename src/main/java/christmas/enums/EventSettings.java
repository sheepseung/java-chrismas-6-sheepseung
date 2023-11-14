package christmas.enums;

import java.math.BigDecimal;

public enum EventSettings {
    PRESENT_STANDARD_AMOUNT(new BigDecimal(120000)),
    PRESENT_VALUE(new BigDecimal(25000)),
    D_DAY_DISCOUNT_START_VALUE(new BigDecimal(1000)),
    D_DAY_DISCOUNT_VALUE(new BigDecimal(100)),
    STANDARD_DISCOUNT_VALUE(new BigDecimal(2023)),
    SPECIAL_DAY_DISCOUNT_VALUE(new BigDecimal(1000));

    private final BigDecimal eventAmount;

    EventSettings(BigDecimal eventAmount) {
        this.eventAmount = eventAmount;
    }

    public BigDecimal getAmount() {
        return eventAmount;
    }
}
