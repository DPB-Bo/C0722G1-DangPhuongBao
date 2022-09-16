package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Person;

import java.util.Scanner;

public interface IPeopleService {
    Scanner scanner = new Scanner(System.in);

    void add();

    void display();

    void remove();

    static Object inputInformation(String name) {
        System.out.printf("\nNhập vào mã %s: ", name);
        String codeStudent = scanner.nextLine();

        System.out.printf("\nNhập vào họ và tên %s: ", name);
        String nameStudent = scanner.nextLine();

        System.out.printf("\nNhập vào ngày sinh của %s: ", name);
        String birthdayStudent = scanner.nextLine();

        System.out.printf("\nNhập vào giới tính của %s: ", name);
        String tempGender = scanner.nextLine();
        Boolean gender = IPeopleService.checkGender(tempGender);

        return new Person(codeStudent, nameStudent, birthdayStudent, gender) {
        };
    }

    static Boolean checkGender(String tempGender) {
        if (tempGender.equals("Trai")) {
            return true;
        } else if (tempGender.equals("Gái")) {
            return false;
        } else {
            return null;
        }
    }
}
