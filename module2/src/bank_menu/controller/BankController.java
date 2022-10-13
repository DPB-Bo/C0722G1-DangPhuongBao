package bank_menu.controller;

import bank_menu.service.BankAccountService;
import bank_menu.service.BankAccountServiceImpl;

import java.util.Scanner;

import static bank_menu._enum.BankEnum.PAYACCOUNT;
import static bank_menu._enum.BankEnum.SAVEACCOUNT;

public class BankController {
    private Scanner SCANNER = new Scanner(System.in);

    private BankAccountService bankAccountService = new BankAccountServiceImpl();

    public void BankMainMenu() {
        while (true) {
            System.out.println("\n------------ CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG ------------\n" +
                    "\n" +
                    "Chọn chứ năng theo số (để tiếp tục):\n" +
                    "1.Thêm mới\n" +
                    "2.Xoá\n" +
                    "3.Xem danh sách các tài khoản ngân hàng\n" +
                    "4.Tìm kiếm\n" +
                    "5.Thoát");

            String choice = SCANNER.nextLine();


            switch (choice) {
                case "1":
                    BankAddMenu();
                case "2":
                    bankAccountService.deleteAccount();
                case "3":
                    bankAccountService.display();
                case "4":
                    bankAccountService.search();
                case "5":
                    System.out.println("Cảm ơn đã sử dụng ứng dụng!");
                    return;
                default:
                    System.out.println("Không có lựa chọn này. Vui lòng nhập lại!");
            }
        }
    }

    public void BankAddMenu() {
        System.out.println("\n------------ THÊM MỚI TÀI KHOẢN NGÂN HÀNG ------------\n" +
                "\n" +
                "Chọn chứ năng theo số (để tiếp tục):\n" +
                "1.Thêm mới tài khoản tiết kiệm\n" +
                "2.Thêm mới tải khoản thanh toán\n" +
                "3.Thoát");

        String choice = SCANNER.nextLine();
        switch (choice) {
            case "1":
                bankAccountService.addAccount(SAVEACCOUNT);
            case "2":
                bankAccountService.addAccount(PAYACCOUNT);
            case "3":
                System.out.println("Thoát thêm mới!");
                return;
            default:
                System.out.println("Không có lựa chọn này. Vui lòng nhập lại!");
        }
    }

    ;

}
