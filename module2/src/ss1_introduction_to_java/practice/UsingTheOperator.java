package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class UsingTheOperator {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chiều dài: ");
        width = scanner.nextFloat();
        System.out.println("Nhập và độ cao: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Diện tích của hình chữ nhật là: " + area);
    }
}
