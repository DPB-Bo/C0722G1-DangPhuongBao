package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Person;

import java.util.List;
import java.util.Scanner;

public interface IPeopleService {
    Scanner scanner = new Scanner(System.in);

    void add();

    void display();

    static void remove(List listName, String className) {
        System.out.printf("\nMời bạn nhập mã %s cần xóa: ", className);
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int index = 0; index < listName.size(); index++) {
            if (((Person) listName.get(index)).getCode().equals(code)) {
                System.out.printf("\nBạn có chắc muốn xóa %s này không? Nhập Y: yes, N: no\n", className);
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    listName.remove(index);
                    System.out.println("\nXóa thành công");
                } else {
                    System.out.println("\nXoá không thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("\nKhông tìm thấy đối tượng cần xóa.");
        }
    }


    static String[] inputInformation(String name) {
        System.out.printf("\nNhập vào mã %s: ", name);
        String codeStudent = scanner.nextLine();

        System.out.printf("\nNhập vào họ và tên %s: ", name);
        String nameStudent = scanner.nextLine();

        System.out.printf("\nNhập vào ngày sinh của %s: ", name);
        String birthdayStudent = scanner.nextLine();

        System.out.printf("\nNhập vào giới tính của %s: ", name);
        String tempGender = scanner.nextLine();

        return new String[]{codeStudent, nameStudent, birthdayStudent, tempGender};
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
