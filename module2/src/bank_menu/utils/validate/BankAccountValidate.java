package bank_menu.utils.validate;

import bank_menu.utils.exception.CodeAccountException;
import bank_menu.utils.exception.OwnerNameException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class BankAccountValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    public String validateCodeAccount() {
        while (true) {
            String regex = "[0-9]{9}";
            try {
                System.out.println("Nhập vào mã tài khoản (9 số)");
                String codeAccount = SCANNER.next();

                if (!(codeAccount.matches(regex))) {
                    throw new CodeAccountException("Mã tài khoản không hợp lệ");
                }
                return codeAccount;
            } catch (CodeAccountException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public String validateOwnerName() {
        String regex = "([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        while (true) {
            try {
                System.out.println("Nhập vào tên chử tài khoản: ");
                String name = SCANNER.nextLine();
                if (!(name.matches(regex))) {
                    throw new OwnerNameException("Tên không hợp lệ!");
                }
                return name;
            } catch (OwnerNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateDateCreate() {
        while (true) {
            try {
                System.out.println("Nhập vào ngày tạo tài khoản: ");
                String dateStr = SCANNER.nextLine();
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Date date = sdf.parse(dateStr);
                LocalDate localDate = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
                return dateStr;
            } catch (ParseException e) {
                System.out.println("Error parsing date string");
            }
        }
    }
}
