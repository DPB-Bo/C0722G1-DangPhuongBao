package ss17_binary_serialization.exercise.exercise1.controller;

import ss17_binary_serialization.exercise.exercise1.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private final ProductService PRODUCT_SERVICE = new ProductService();
    private final Scanner SCANNER = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.print("*********** MENU ***********" +
                    "0.Thoát\n" +
                    "1.Thêm sản phẩm\n" +
                    "2.Hiển thị sản phẩm\n" +
                    "3.Tìm kiếm sản phẩm\n" +
                    "Nhập lựa chọn ở đây: ");
            int choice = Integer.parseInt(SCANNER.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Cảm ơn đã sử dụng ứng dụng! ");
                    return;
                case 1:
                    PRODUCT_SERVICE.add();
                    break;
                case 2:
                    PRODUCT_SERVICE.display();
                    break;
                case 3:
                    PRODUCT_SERVICE.search();
                    break;
                default:
                    System.out.println("\nKhông có lựa chọn này!");
                    break;
            }
        }
    }
}
