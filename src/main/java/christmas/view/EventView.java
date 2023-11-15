package christmas.view;

import christmas.domain.Bill;
import christmas.enums.EventMessage;
import christmas.parser.Parser;

import java.math.BigDecimal;

public class EventView {

    public static void printPriceBeforeDiscount(Bill bill) {
        System.out.printf(EventMessage.BEFORE_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(),
                Parser.BigDecimalToFormmatedString(bill.getTotalPrice()));
    }

    public static void printPresentDetails(boolean canPresent) {
        System.out.println(EventMessage.PRESENT_EVENT_OUTPUT_MESSAGE.getMessage());
        if (canPresent) {
            System.out.println(EventMessage.PRESENT_ITEM.getMessage());
            return;
        }
        System.out.println(EventMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printEventResultDetails(String eventResult) {
        System.out.println(EventMessage.EVENT_DISCOUNT_CONTENTS_OUTPUT_MESSAGE.getMessage());
        if (!eventResult.isBlank()) {
            System.out.println(eventResult);
            return;
        }
        System.out.println(EventMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printTotalBenefitAmount(BigDecimal totalBenefit) {
        System.out.println(EventMessage.TOTAL_BENEFIT_OUTPUT_MESSAGE.getMessage());
        if (totalBenefit.compareTo(new BigDecimal(0)) == 1) {
            System.out.println("-" + Parser.BigDecimalToFormmatedString(totalBenefit) + "\n");
            return;
        }
        System.out.println(EventMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printPriceAfterDiscount(Bill bill, BigDecimal totalBenefitAmount) {
        System.out.printf(EventMessage.AFTER_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(),
                Parser.BigDecimalToFormmatedString(bill.getTotalPrice()
                        .subtract(totalBenefitAmount)));
    }

    public static void printBadge(String badge) {
        System.out.printf(EventMessage.BADGE_EVENT_MESSAGE.getMessage());
        if (badge == null) System.out.println(EventMessage.NO_APPLIED_VALUE);
        System.out.println(badge + '\n');
    }
}
