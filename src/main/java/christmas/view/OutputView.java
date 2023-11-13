package christmas.view;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.enums.OutputMessage;

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
        System.out.printf(OutputMessage.BEFORE_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(), bill.getTotalPrice());
    }

    public static void printPriceAfterDiscount(Bill bill){
        System.out.printf(OutputMessage.AFTER_DISCOUNT_PRICE_OUTPUT_MESSAGE.getMessage(), bill.getTotalPrice());
    }

    public static void printEventDiscountDetails(String discountDetails){
        if(discountDetails.isBlank()) discountDetails = OutputMessage.NO_APPLIED_VALUE.getMessage();

        System.out.println(OutputMessage.EVENT_DISCOUNT_CONTENTS_MESSAGE.getMessage() + discountDetails);
    }
}
