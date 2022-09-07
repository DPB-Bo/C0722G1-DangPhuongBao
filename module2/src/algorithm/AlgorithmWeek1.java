package algorithm;

import java.util.Scanner;

public class AlgorithmWeek1 {
    static Scanner scanner = new Scanner(System.in);

    public static String drawIsosceleTriangle() {
        String result = "";
        System.out.println("Nhập vào chiều cao:");
        int x = Integer.parseInt(scanner.nextLine());
        int left = x - 1;
        int right = x + 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= left; j++) {
                result += " ";
            }
            for (int m = 1; m <= (2 * i) - 1; m++) {
                if (i == 1) continue;
                if (m == 1 || m == (2 * i) - 1) {
                    result += i - 1;
                } else {
                    result += " ";
                }
            }
            for (int n = right; n <= (2 * x) - 1; n++) {
                result += " ";
            }
            result += "\n";
            left--;
            right++;
        }
        left = 1;
        right = 2 * x - 2;
        for (int i = x - 1; i > 0; i--) {
            for (int j = 1; j <= left; j++) {
                result += " ";
            }
            for (int m = 1; m <= (2 * i) - 1; m++) {
                if (i == 1) continue;
                if (m == 1 || m == (2 * i) - 1) {
                    result += i - 1;
                } else {
                    result += " ";
                }
            }
            for (int n = right; n <= (2 * x) - 1; n++) {
                result += " ";
            }
            result += "\n";
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(drawIsosceleTriangle());
    }
}
