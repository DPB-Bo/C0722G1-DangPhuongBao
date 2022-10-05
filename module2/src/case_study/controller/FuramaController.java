package case_study.controller;

import case_study.service.CustomerService;
import case_study.service.EmployeeService;
import case_study.service.impl.CustomerServiceImpl;
import case_study.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private final Scanner SCANNER = new Scanner(System.in);

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    private final CustomerService customerService = new CustomerServiceImpl();

    public void displayMainMenu() {
        while (true) {
            System.out.print("-------------- MAIN MENU --------------\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                    displayOptionOne();
                    break;
                case 2:
                    displayOptionTwo();
                    break;
                case 3:
                    displayOptionThree();
                    break;
                case 4:
                    displayOptionFour();
                    break;
                case 5:
                    displayOptionFive();
                    break;
                case 6:
                    System.out.println("Cảm ơn đã sử dụng ứng dụng!");
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private int inputChoice() {
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            choice = 0;
        }
        return choice;
    }

    private void displayOptionOne() {
        while (true) {
            System.out.print("-------------- EMPLOYEE MANAGEMENT --------------\n" +
                    "1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.print("\nKhông có lựa chọn này!");
                    break;
            }
        }

    }

    private void displayOptionTwo() {
        while (true) {
            System.out.print("-------------- CUSTOMER MANAGEMENT --------------" +
                    "1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n" +
                    "Enter your choice: ");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.print("\nKhông có lựa chọn này!");
                    break;
            }
        }

    }

    private void displayOptionThree() {
        while (true) {
            System.out.print("-------------- FACILITY MANAGEMENT --------------" +
                    "1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n" +
                    "Enter your choice: ");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return;
                default:
                    System.out.print("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private void displayOptionFour() {
        while (true) {
            System.out.print("-------------- BOOKING MANAGEMENT --------------" +
                    "1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }

    private void displayOptionFive() {
        while (true) {
            System.out.print("-------------- PROMOTION MANAGEMENT --------------" +
                    "1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");

            int choice = inputChoice();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    return;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }
}
