package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputMessage;

public class InputView {

    public static String inputDate() {
        System.out.println(InputMessage.DATE_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputOrder() {
        System.out.println(InputMessage.MENU_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
