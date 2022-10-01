package test_sth.test_java_work.test_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("write sth: ");
        String sth = scanner.nextLine();
        //COACH123
        //MOTOR123
        //TRUCK123
        Pattern pattern = Pattern.compile("^(COACH|MOTOR|TRUCK)[0-9]{3}");
        Matcher matcher = pattern.matcher(sth);
        System.out.println(matcher.matches());
    }
}
