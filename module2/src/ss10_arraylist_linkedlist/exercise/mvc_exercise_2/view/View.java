package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.view;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.controller.CarController;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl.ProducerService;

public class View {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.displayMainMenu();
    }
}
