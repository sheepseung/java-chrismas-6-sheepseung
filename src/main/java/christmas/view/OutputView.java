package christmas.view;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.enums.OutputMessage;
import christmas.parser.Parser;

import java.math.BigDecimal;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(OutputMessage.START_OUTPUT_MESSAGE.getMessage());
    }

    public static void printEventPreviewMessage(int day) {
        System.out.printf(OutputMessage.EVENT_PREVIEW_OUTPUT_MESSAGE.getMessage(), day);
    }

    public static void printOrderDetails(Order orders) {
        System.out.print(OutputMessage.ORDER_DETAILS_OUTPUT_MESSAGE.getMessage() + orders.toString());
    }

    public static void printPriceBeforeDiscount(Bill bill) {
        System.out.printf(OutputMessage.BEFORE_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(),
                Parser.BigDecimalToFormmatedString(bill.getTotalPrice()));
    }

    public static void printPriceAfterDiscount(Bill bill){
        System.out.printf(OutputMessage.AFTER_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(),
                Parser.BigDecimalToFormmatedString(bill.getTotalPrice()));
    }

    public static void printPresentDetails(boolean canPresent){
        System.out.println(OutputMessage.PRESENT_EVENT_OUTPUT_MESSAGE.getMessage());
        if(canPresent) {
            System.out.println(OutputMessage.PRESENT_ITEM.getMessage());
            return;
        }
        System.out.println(OutputMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printTotalBenefitAmount(BigDecimal totalBenefit){
        System.out.println(OutputMessage.TOTAL_BENEFIT_OUTPUT_MESSAGE.getMessage());
        if(totalBenefit.compareTo(new BigDecimal(0)) == 1) {
            System.out.println("-" + Parser.BigDecimalToFormmatedString(totalBenefit) + "\n");
            return;
        }
        System.out.println(OutputMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printEventDiscountDetails(String discountDetails){
        System.out.println(OutputMessage.EVENT_DISCOUNT_CONTENTS_MESSAGE.getMessage());
        if(!discountDetails.isBlank()){
            System.out.println(discountDetails);
            return;
        }
        System.out.println(OutputMessage.NO_APPLIED_VALUE.getMessage());
    }

    public static void printBadge(String badge){
        System.out.printf(OutputMessage.PRESENT_EVENT_OUTPUT_MESSAGE.getMessage());
        if(badge == null) System.out.println(OutputMessage.NO_APPLIED_VALUE);
        System.out.println(badge + '\n');
    }
}
