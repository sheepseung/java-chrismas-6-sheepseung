package christmas.view;

import christmas.domain.Orders;
import christmas.enums.OutputMessage;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(OutputMessage.START_OUTPUT_MESSAGE.getMessage());
    }

    public static void printEventPreviewMessage(int day){
        System.out.printf(OutputMessage.EVENT_PREVIEW_OUTPUT_MESSAGE.getMessage(), day);
    }
    public static void printOrderDetails(Orders orders){
        System.out.println(OutputMessage.ORDER_DETAILS_OUTPUT_MESSAGE.getMessage() + orders.toString());
    }
}
