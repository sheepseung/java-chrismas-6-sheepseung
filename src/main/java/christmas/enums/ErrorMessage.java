package christmas.enums;

public enum ErrorMessage {
    INPUT_DAY_ERROR_MESSAGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    INPUT_ORDER_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
