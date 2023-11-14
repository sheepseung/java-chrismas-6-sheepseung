package christmas;

import christmas.controller.ChristmasEventController;
import christmas.controller.EventController;
import christmas.controller.PlannerController;

public class Application {
    public static void main(String[] args) {
        EventController chrismasEventController = new ChristmasEventController();
        PlannerController plannerController = new PlannerController(chrismasEventController);

        plannerController.run();
    }

}
