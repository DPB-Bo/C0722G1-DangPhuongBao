package ss15_java_exception.exercise.exercise1;

import ss15_java_exception.exercise.exercise1.exception.IllegalTriangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static void inputSideOfTriangle(int n, Integer[] arr) {
        while (true) {
            try {
                System.out.printf("Nhập vào cạnh thứ %d của tam giác: ", n);
                int side = Integer.parseInt(scanner.nextLine());
                if (side <= 0) {
                    throw new IllegalTriangle("Độ dài cạnh không hợp lệ! Vui lòng nhập lại!");
                } else {
                    arr[n] = side;
                    break;
                }
            } catch (IllegalTriangle e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Độ dài cạnh không hợp lệ! Vui lòng nhập lại!");
            }
        }
    }

    private static void checkLegalTriangle(Integer[] arr) {
        while (true) {
            try {
                for (int i = 1; i < 4; i++) {
                    inputSideOfTriangle(i, arr);
                }
                boolean legalTriangle = (arr[0] + arr[1]) <= arr[2] || (arr[0] + arr[2]) <= arr[1] || (arr[2] + arr[1]) <= arr[0];
                if (legalTriangle) {
                    throw new IllegalArgumentException("Tam giác không tồn tại.Vui lòng nhập lại!");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tam giác hợp lệ!");
        System.out.println("Độ dài 3 cạnh: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[3];
        checkLegalTriangle(arr);
    }

}
