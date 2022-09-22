package ss12_collection_java.exercise.exercise_1.service.impl;

import ss12_collection_java.exercise.exercise_1.model.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getPrice() < product2.getPrice()) {
            return -1;
        } else if (product1.getPrice() > product2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareWord(Product product1, Product product2) {
        return product1.getName().compareTo(product2.getName());
    }
}