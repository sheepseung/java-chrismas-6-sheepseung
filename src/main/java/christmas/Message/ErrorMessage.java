package christmas.Message;

public enum ErrorMessage {
    INPUT_NOT_INTEGER_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요."),
    INPUT_NULL_ERROR_MESSAGE("[ERROR] : 정확한 값을 입력해 주세요.")
    ;

    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
