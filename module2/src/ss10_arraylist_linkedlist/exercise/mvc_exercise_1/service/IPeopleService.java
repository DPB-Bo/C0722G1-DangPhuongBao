package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Person;

import java.util.List;
import java.util.Scanner;

public interface IPeopleService {
    Scanner scanner = new Scanner(System.in);

//    void add();
//
//    void display();
//
//    default void remove(List listName, String className) {
//        System.out.print("Mời bạn nhập mã sinh viên cần xóa: ");
//        String code = scanner.nextLine();
//        boolean flagDelete = false;
//        for (int i = 0; i < listName.size(); i++) {
//            if (((Person) listName.get(i)).getCode().equals(code)) {
//                System.out.println("\nBạn có chắc muốn xóa sinh viên này không? Nhập Y: yes, N: no");
//                String choice = scanner.nextLine();
//                if (choice.equals("Y")) {
//                    listName.remove(i);
//                    System.out.println("\nXóa thành công");
//                } else {
//                    System.out.println("\nXoá không thành công");
//                }
//                flagDelete = true;
//                break;
//            }
//        }
//        if (!flagDelete) {
//            System.out.println("\nKhông tìm thấy đối tượng cần xóa.");
//        }
//    }
//
//
//    default void inputInformation(String name) {
//        System.out.printf("\nNhập vào mã %s: ", name);
//        String codeStudent = scanner.nextLine();
//
//        System.out.printf("\nNhập vào họ và tên %s: ", name);
//        String nameStudent = scanner.nextLine();
//
//        System.out.printf("\nNhập vào ngày sinh của %s: ", name);
//        String birthdayStudent = scanner.nextLine();
//
//        System.out.printf("\nNhập vào giới tính của %s: ", name);
//        String tempGender = scanner.nextLine();
//        Boolean gender = IPeopleService.checkGender(tempGender);
//
//    }
//
//    static Boolean checkGender(String tempGender) {
//        if (tempGender.equals("Trai")) {
//            return true;
//        } else if (tempGender.equals("Gái")) {
//            return false;
//        } else {
//            return null;
//        }
//    }
}
