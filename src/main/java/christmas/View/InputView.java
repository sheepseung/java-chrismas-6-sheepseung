package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Message.InputMessage;
import christmas.Parser.Parser;

public class InputView {

    public static int inputDate(){
        System.out.println(InputMessage.DATE_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return Parser.stringToIntPaser(input);
    }

}
