package christmas;

import christmas.controller.ChrismasEventController;
import christmas.controller.EventController;
import christmas.controller.PlannerController;

public class Application {
    public static void main(String[] args) {
        EventController chrismasEventController = new ChrismasEventController();
        PlannerController plannerController = new PlannerController(chrismasEventController);

        plannerController.run();
    }

}
