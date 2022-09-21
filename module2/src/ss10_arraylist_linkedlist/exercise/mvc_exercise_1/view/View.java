package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.view;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.controller.PersonController;

public class View {
    public static void main(String[] args) {
        PersonController personController = new PersonController();
        personController.displayMenu();
    }
}
