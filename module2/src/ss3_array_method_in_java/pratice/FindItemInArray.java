package ss3_array_method_in_java.pratice;

import java.util.Arrays;
import java.util.Scanner;

public class FindItemInArray {
    public static void main(String[] args) {
        Integer[] arrNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Mảng sẵn có là: " + Arrays.toString(arrNumbers));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào giá trị muốn tìm kiếm: ");
        Integer n = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int item : arrNumbers) {
            if (item == n) {
                found = true;
                break;
            }
        }
        System.out.printf(found ? "Giá trị %d tồn tại trong mảng" : "Giá trị %d không tồn tại trong mảng", n);
    }
}
