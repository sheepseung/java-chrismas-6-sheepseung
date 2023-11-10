package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;

public class PlannerController {

    public void run(){
        OutputView.printStartMessage();
        int date = InputView.inputDate();
    }
}
