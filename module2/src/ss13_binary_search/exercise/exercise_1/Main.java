package ss13_binary_search.exercise.exercise_1;

import java.util.Scanner;

public class Main {

    private static String binarySearch(String str) {
        StringBuilder result = new StringBuilder("" + str.charAt(0));
        for (int index = 0; index < str.length(); index++) {
            if (result.charAt(result.length() - 1) < str.charAt(index)) {
                result.append(str.charAt(index));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();

        System.out.println("\nChuỗi vừa nhập: " + str);
        System.out.println("\nChuỗi tăng dần có độ dài lớn nhất là: " + binarySearch(str));
    }
}
