package ss12_collection_java.exercise.exercise_1.controller;

import ss12_collection_java.exercise.exercise_1.service.IProductService;
import ss12_collection_java.exercise.exercise_1.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private final Scanner scanner = new Scanner(System.in);

    private IProductService productService = new ProductService();


    public void displayMenu() {
        while (true) {
            System.out.print("\n******* QUẢN LÝ SẢN PHẨM *******\n" +
                    "\n" +
                    " 1.Thêm sản phẩm\n" +
                    " 2.Sửa thông tin sản phẩm theo id\n" +
                    " 3.Xoá sản phẩm theo id\n" +
                    " 4.Hiển thị danh sách sản phẩm\n" +
                    " 5.Tìm kiếm sản phẩm theo tên\n" +
                    " 6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n" +
                    " 7.Thoát\n" +
                    " 8.Thêm dữ liệu" +
                    "\n" +
                    "Nhập vào lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            final int optionOne = 1;
            final int optionTwo = 2;
            final int optionThree = 3;
            final int optionFour = 4;
            final int optionFive = 5;
            final int optionSix = 6;
            final int optionSeven = 7;
            final int optionEight = 8;

            switch (choice) {
                case optionOne:
                    productService.add();
                    break;
                case optionTwo:
                    productService.update();
                    break;
                case optionThree:
                    productService.remove();
                    break;
                case optionFour:
                    productService.display();
                    break;
                case optionFive:
                    productService.search();
                    break;
                case optionSix:
                    productService.sortByPrice();
                    break;
                case optionSeven:
                    System.out.println("\n Cảm ơn đã sửa dụng ứng dụng! ");
                    return;
                case optionEight:
                    productService.addData();
                    break;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }
}
