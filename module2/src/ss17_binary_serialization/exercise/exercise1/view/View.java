package ss17_binary_serialization.exercise.exercise1.view;

import ss17_binary_serialization.exercise.exercise1.controller.ProductController;

public class View {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.display();
    }
}
