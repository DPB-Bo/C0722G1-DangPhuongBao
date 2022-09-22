package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.controller;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl.CoachService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl.MotorService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl.TruckService;

import java.util.Scanner;

public class CarController {
    private static final Scanner scanner = new Scanner(System.in);
    private final CoachService coachService = new CoachService();
    private final MotorService motorService = new MotorService();
    private final TruckService truckService = new TruckService();
    private final int optionOne = 1;
    private final int optionTwo = 2;
    private final int optionThree = 3;
    private final int optionFour = 4;
    private final int optionFive = 5;

    public void displayMainMenu() {
        while (true) {
            System.out.print("\n*******CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG*******\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Tìm kiếm theo biển kiểm soát\n" +
                    "5. Thoát\n" +
                    "Nhập vào lựa chọn: ");
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
                    displayOptionFour();
                    break;
                case optionFive:
                    System.out.println("\nCảm ơn đã sử dụng ứng dụng !\n");
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!\n");
            }
        }
    }

    private void displaySubMenu(String missionName) {
        System.out.print("\n-----" + missionName + "-----\n" +
                "1.Xe tải\n" +
                "2.Oto\n" +
                "3.Xe máy\n" +
                "4.Thoát\n" +
                "Chọn loại xe: ");
    }

    private void displayOptionOne() {
        while (true) {
            displaySubMenu("THÊM MỚI");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case optionOne:
                    coachService.add();
                    break;
                case optionTwo:
                    truckService.add();
                    break;
                case optionThree:
                    motorService.add();
                    return;
                case optionFour:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private void displayOptionTwo() {
        while (true) {
            displaySubMenu("HIỂN THỊ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case optionOne:
                    coachService.display();
                    break;
                case optionTwo:
                    truckService.display();
                    break;
                case optionThree:
                    motorService.display();
                    return;
                case optionFour:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private void displayOptionThree() {
        System.out.print("\nNhập vào biển kiểm soát của xe cần xoá: ");
        String code = scanner.nextLine();

        boolean isFoundCode = coachService.remove(code) && truckService.remove(code) && truckService.remove(code);

        if (!isFoundCode) {
            System.out.println("\nKhông tìm thấy biển kiểm soát xe cần xoá! ");
        }
    }

    private void displayOptionFour() {
        System.out.print("\nNhập vào biển kiểm soát của xe cần tìm: ");
        String code = scanner.nextLine();

        boolean isFoundCode = coachService.search(code) || truckService.search(code) || truckService.search(code);

        if (!isFoundCode) {
            System.out.println("\nKhông tìm thấy biển kiểm soát xe trong dữ liệu! ");
        }
    }
}
