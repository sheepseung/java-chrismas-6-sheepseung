package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.message.InputMessage;
import christmas.parser.Parser;

public class InputView {

    public static int inputDate() {
        System.out.println(InputMessage.DATE_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return Parser.stringToIntPaser(input);
    }

    public static String inputMenu(){
        System.out.println(InputMessage.MENU_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }


}
