package christmas.Message;

public enum InputMessage {
    DATE_INPUT_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");


    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
