package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Person;

import java.util.List;
import java.util.Scanner;

public interface IPeopleService {
    Scanner scanner = new Scanner(System.in);

    void add();

    void display();

    void remove();

    boolean search(String code);

    void addFakeDate();

    void sortByName();

}
