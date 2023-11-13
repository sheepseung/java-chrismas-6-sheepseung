package christmas;

import christmas.controller.ChrismasEventController;
import christmas.controller.EventController;
import christmas.controller.PlannerController;
import christmas.domain.Order;

public class Application {
    public static void main(String[] args) {
        Order order = new Order();
        EventController chrismasEventController = new ChrismasEventController(order);
        PlannerController plannerController = new PlannerController(chrismasEventController, order);

        plannerController.run();
    }

}
