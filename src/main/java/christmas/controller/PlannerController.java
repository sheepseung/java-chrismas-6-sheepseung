package christmas.controller;

import christmas.domain.ReservationDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {

    public void run(){
        OutputView.printStartMessage();
        int date = InputView.inputDate();
        ReservationDay day = new ReservationDay(date);


        String menu = InputView.inputMenu();
    }
}
