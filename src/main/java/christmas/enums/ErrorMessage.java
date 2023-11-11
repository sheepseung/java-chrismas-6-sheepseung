package christmas.enums;

public enum ErrorMessage {
    INPUT_NOT_INTEGER_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요."),
    INPUT_NULL_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요."),
    INPUT_OVER_RANGE_ERROR_MESSAGE("[ERROR]: 날짜를 확인해 주세요"),

    ORDER_NON_EXISTENT_MENU_ERROR_MESSAGE("[ERROR] : 없는 메뉴입니다."),
    ORDER_UNDER_ZERO_NUMBER_ERROR_MESSAGE("[ERROR] : 입력하신 메뉴당 한 개 이상을 주문해 주세요"),
    ORDER_DIFFERENT_FORMAT_ERROR_MESSAGE("[ERROR] : 입력 형식을 맞춰 주세요."),
    ORDER_DUPLICATE_MENU_ERROR_MESSAGE("[ERROR] : 중복 메뉴가 존재합니다."),

    MINIMUM_ORDER_AMOUNT_ERROR_MESSAGE("[ERROR] : 최소 주문 금액을 확인해주세요."),
    MAXIMUM_ORDER_QUANTITY_ERROR_MESSAGE("[ERROR] : 최대 20개 까지 주문 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
