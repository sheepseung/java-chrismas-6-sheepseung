package christmas.parser;

import christmas.enums.EventMessage;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class EventDetailsParser {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    public static String parsePresentEventDetail(BigDecimal discountValue) {
        String discountDetail = (EventMessage.PRESENT_DISCOUNT_MESSAGE.getMessage()
                + DECIMAL_FORMAT.format(discountValue) + "원\n");
        return discountDetail;
    }

    public static String parseDDayDiscountEventDetail(BigDecimal discountValue) {
        String discountDetail = (EventMessage.D_DAY_DISCOUNT_MESSAGE.getMessage()
                + DECIMAL_FORMAT.format(discountValue) + "원\n");
        return discountDetail;
    }

    public static String parseWeekdayDiscountEventDetail(BigDecimal discountValue) {
        String discountDetail = EventMessage.WEEKDAY_DISCOUNT_MESSAGE.getMessage();
        if (discountValue.compareTo(new BigDecimal(0)) != 0) {
            return discountDetail + (DECIMAL_FORMAT.format(discountValue) + "원\n");
        }
        return discountDetail + EventMessage.NO_APPLIED_VALUE.getMessage();
    }

    public static String parseWeekendDiscountEventDetail(BigDecimal discountValue) {
        String discountDetail = (EventMessage.WEEKEND_DISCOUNT_MESSAGE.getMessage());
        if (discountValue.compareTo(new BigDecimal(0)) != 0) {
            return discountDetail + (DECIMAL_FORMAT.format(discountValue) + "원\n");
        }
        return discountDetail + EventMessage.NO_APPLIED_VALUE.getMessage();
    }

    public static String paresSpecialDayDiscountEventDetail(BigDecimal discountValue) {
        String discountDetail = (EventMessage.SPECIAL_DAY_DISCOUNT_MESSAGE.getMessage());
        if (discountValue.compareTo(new BigDecimal(0)) == 1) {
            return discountDetail + (DECIMAL_FORMAT.format(discountValue) + "원\n");
        }
        return discountDetail + EventMessage.NO_APPLIED_VALUE.getMessage();
    }
}
