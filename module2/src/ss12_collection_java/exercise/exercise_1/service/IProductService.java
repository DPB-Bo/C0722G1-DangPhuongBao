package ss12_collection_java.exercise.exercise_1.service;

import java.util.Scanner;

public interface IProductService {
    Scanner scanner = new Scanner(System.in);

    void add();

    void update();

    void remove();

    void display();

    void search();

    void sortByPrice();
}
