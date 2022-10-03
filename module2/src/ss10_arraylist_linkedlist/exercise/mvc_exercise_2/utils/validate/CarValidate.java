package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.validate;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.exception.car_exception.CodeException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarValidate {
    private final Scanner SCANNER = new Scanner(System.in);
    private String regex;
    private Pattern pattern;
    private Matcher matcher;

    public String checkCodeOfCar() {
        String code;

        while (true) {
            try {
                System.out.print("\nNhập vào biển kiểm soát: ");
                code = SCANNER.nextLine();
                regex = "^(COACH|MOTOR|TRUCK)[0-9]{3}";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(code);
                if (!matcher.matches()) {
                    throw new CodeException("Biển số không hợp lệ (Tên xe in hoa và 3 chữ số )");
                }
                break;
            } catch (CodeException e) {
                System.out.println(e.getMessage());
            }
        }

        return code;
    }


}
