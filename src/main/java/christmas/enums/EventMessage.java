package christmas.enums;

public enum EventMessage {
    BEFORE_DISCOUNT_PRICE_OUTPUT_MESSAGE("\n<할인 전 총주문 금액>\n%s원\n"),
    AFTER_DISCOUNT_PRICE_OUTPUT_MESSAGE("<할인 후 예상 결제 금액>\n%s원"),
    EVENT_DISCOUNT_CONTENTS_MESSAGE("\n<혜택 내역>"),
    PRESENT_EVENT_OUTPUT_MESSAGE("\n<증정 메뉴>"),
    TOTAL_BENEFIT_OUTPUT_MESSAGE("<총혜택 금액>"),

    PRESENT_DISCOUNT_MESSAGE("증정 이벤트: -"),
    D_DAY_DISCOUNT_MESSAGE("크리스마스 디데이 할인: -"),
    WEEKDAY_DISCOUNT_MESSAGE("평일 할인: -"),
    WEEKEND_DISCOUNT_MESSAGE("주말 할인: -"),
    SPECIAL_DAY_DISCOUNT_MESSAGE("특별 할인: -"),
    BADGE_EVENT_MESSAGE("<12월 이벤트 배지>\n"),
    NO_APPLIED_VALUE("없음\n"),


    PRESENT_ITEM("샴페인 1개");

    private final String message;

    EventMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
