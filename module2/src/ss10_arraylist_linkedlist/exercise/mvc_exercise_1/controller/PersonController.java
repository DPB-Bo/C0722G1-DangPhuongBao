package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.controller;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.IStudentService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.ITeacherService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.StudentService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentService studentService = new StudentService();
    private static final ITeacherService teacherService = new TeacherService();
    final static int optionOne = 1;
    final static int optionTwo = 2;
    final static int optionThree = 3;
    final static int optionFour = 4;


    public static void displayMenu() {
        while (true) {
            System.out.print("\n-------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN –------\n" +
                    "Chọn chức năng theo số để tiếp tục:\n" +
                    "1. Thêm mới giảng viên hoặc học sinh\n" +
                    "2. Xóa giảng viên hoặc học sinh\n" +
                    "3. Xem danh sách giảng viên hoặc học sinh\n" +
                    "4. Thoát\n" +
                    "Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case optionOne:
                    displayOptionOne();
                    break;
                case optionTwo:
                    displayOptionTwo();
                    break;
                case optionThree:
                    displayOptionThree();
                    break;
                case optionFour:
                    System.out.println("\nCảm ơn đã sử dụng ứng dụng !");
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
            }
        }
    }

    private static void displayOptionThree() {
        while (true) {
            displayChooseMenu("DANH SÁCH");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case optionOne:
                    studentService.display();
                    break;
                case optionTwo:
                    teacherService.display();
                    break;
                case optionThree:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private static void displayOptionTwo() {
        while (true) {
            displayChooseMenu("XOÁ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case optionOne:
                    IStudentService.remove();
                    break;
                case optionTwo:
                    ITeacherService.remove();
                    break;
                case optionThree:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private static void displayOptionOne() {
        while (true) {
            displayChooseMenu("THÊM MỚI");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case optionOne:
                    studentService.add();
                    break;
                case optionTwo:
                    teacherService.add();
                    break;
                case optionThree:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private static void displayChooseMenu(String menuName) {
        System.out.print("\n-----" + menuName + "-----\n" +
                "1.Sinh viên\n" +
                "2.Giáo viên\n" +
                "3.Thoát\n" +
                "Chọn chức năng: ");
    }
}
