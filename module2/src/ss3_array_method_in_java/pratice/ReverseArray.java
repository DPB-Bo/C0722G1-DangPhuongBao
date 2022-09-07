package ss3_array_method_in_java.pratice;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập vào độ dài của mảng: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n < 0) System.out.println("Xin nhập lại độ dài phù hợp!");
        } while (n < 0);
        int[] arrNumbers = new int[n];
        for (int i = 0; i < arrNumbers.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arrNumbers[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(arrNumbers));
        for (int i = 0; i < (arrNumbers.length) / 2; i++) {
            arrNumbers[i] = arrNumbers[arrNumbers.length - 1 - i] + (arrNumbers[arrNumbers.length - 1 - i] = arrNumbers[i]) - arrNumbers[i];
        }
        System.out.println(Arrays.toString(arrNumbers));
    }
}
