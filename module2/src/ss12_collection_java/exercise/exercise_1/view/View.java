package ss12_collection_java.exercise.exercise_1.view;

import ss12_collection_java.exercise.exercise_1.controller.ProductController;

public class View {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.displayMenu();
    }
}
