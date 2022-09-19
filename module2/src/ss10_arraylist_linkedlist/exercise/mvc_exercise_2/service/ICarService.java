package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service;

import java.util.Scanner;

public interface ICarService {
    Scanner scanner = new Scanner(System.in);

    Object inputInformation();

    void add();

    void display();

    boolean remove(String code);

    boolean search(String code);
}
