package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.InputMessage;
import christmas.parser.Parser;

public class InputView {

    public static int inputDate() {
        System.out.println(InputMessage.DATE_INPUT_MESSAGE.getMessage());
        String input = Console.readLine().trim();
        return Parser.stringToIntPaser(input);
    }

    public static String inputOrder(){
        System.out.println(InputMessage.MENU_INPUT_MESSAGE.getMessage());
        return Console.readLine().trim();
    }


}
