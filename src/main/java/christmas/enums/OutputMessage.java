package christmas.enums;

public enum OutputMessage {
    START_OUTPUT_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EVENT_PREVIEW_OUTPUT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_DETAILS_OUTPUT_MESSAGE("\n<주문 메뉴>\n"),
    BEFORE_DISCOUNT_PRICE_OUTPUT_MESSAGE("\n<할인 전 총주문 금액>\n%s원\n"),
    AFTER_DISCOUNT_PRICE_OUTPUT_MESSAGE("\n<할인 후 예상 결제 금액>\n%s원");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
