package christmas.enums;

public enum ErrorMessage {
    INPUT_DAY_ERROR_MESSAGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    ORDER_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    ORDER_ONLY_BEVERAGE_ERROR_MESSAGE("[ERROR] : 음료외의 메뉴를 주문해 주세요."),

    MINIMUM_ORDER_AMOUNT_ERROR_MESSAGE("[ERROR] : 최소 주문 금액을 확인해주세요."),

    MAXIMUM_ORDER_QUANTITY_ERROR_MESSAGE("[ERROR] : 최대 음식 갯수는 20개 까지 주문 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
