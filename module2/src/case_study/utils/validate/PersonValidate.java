package case_study.utils.validate;

import case_study.model.person.Person;
import case_study.utils.exception.person_exception.CodeException;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonValidate {
    private final Scanner SCANNER = new Scanner(System.in);
    private String regex;

    public String validateCode(String str, ArrayList<Person> personArrayList) {
        String alert;
        if (str.equals("customer")) {
            regex = "(CUS)[0-9]{3}";
            alert = "Mã bắt đầu bằng CUS kèm 3 số ngẫu nhiên!";
        } else {
            regex = "(EMP)[0-9]{3}";
            alert = "Mã bắt đầu bằng EMP kèm 3 số ngẫu nhiên!";
        }
        while (true) {
            try {
                System.out.println("Nhập vào mã " + str);
                String code = SCANNER.nextLine();
                if (!(code.matches(regex))) {
                    throw new CodeException(alert);
                }
                for (Person person : personArrayList) {
                    if (person.getCode().equals(code)) {
                        throw new CodeException("Mã đã tồn tại, vui lòng nhập lại!");
                    }
                }
                return code;
            } catch (CodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
