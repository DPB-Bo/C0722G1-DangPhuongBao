package ss13_binary_search.exercise.exercise_3;

import java.util.*;

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

        System.out.print("\nNhập vào một chuỗi: ");
        String str = scanner.nextLine();
        
        str = String.join("", new LinkedHashSet<>(Arrays.asList(str.split(""))));
        System.out.println("\nKết quả: " + binarySearch(str));
    }
}
