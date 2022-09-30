package ss17_binary_serialization.exercise.exercise1.service;

import java.util.Scanner;

public interface IProductService {
    Scanner scanner = new Scanner(System.in);

    void add();

    String validCode();

    String validName();

    boolean checkContainsNumbers(String string);

    String validProducer();

    Integer validPrice();

    String validDescription();

    void display();

    void search();

    void readFile();

    void writeFile();
}
