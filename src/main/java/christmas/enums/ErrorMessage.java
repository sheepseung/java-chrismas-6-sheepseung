package christmas.enums;

public enum ErrorMessage {
    INPUT_NOT_INTEGER_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요."),
    INPUT_NULL_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요."),
    INPUT_OVER_RANGE_ERROR_MESSAGE("[ERROR]: 날짜를 확인해 주세요"),

    ORDER_NON_EXISTENT_MENU_ERROR_MESSAGE("[ERROR] : 없는 메뉴입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
