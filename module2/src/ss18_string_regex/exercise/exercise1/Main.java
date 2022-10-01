package ss18_string_regex.exercise.exercise1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tên lớp học: ");
        String className = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[CAP][0-9]{4}[GHIKLM]$");
        Matcher matcher = pattern.matcher(className);
        System.out.println(matcher.matches());
    }
}
