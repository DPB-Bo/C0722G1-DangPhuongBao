package bank_menu.utils.validate;

import bank_menu.utils.exception.BonusException;
import bank_menu.utils.exception.LimitTimeException;
import bank_menu.utils.exception.SaveMoneyException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class SaveAccountValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    public int validateSaveMoney() {
        while (true) {
            try {
                System.out.println("Nhập vào số tiền tiết kiệm: ");
                int money = Integer.parseInt(SCANNER.nextLine());

                if (money < 0) {
                    throw new SaveMoneyException("Sô tiền tiết kim không hợp lệ: ");
                }
                return money;
            } catch (NumberFormatException | SaveMoneyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateDateSave() {
        while (true) {
            try {
                System.out.println("Nhập vào ngày gửi tiết kiệm: ");
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

    public int validateBonus() {
        while (true) {
            try {
                System.out.println("Nhập vào lãi suất: ");
                int bonus = Integer.parseInt(SCANNER.nextLine());

                if (bonus < 0) {
                    throw new BonusException("Lãi suất không hợp lệ");
                }
                return bonus;

            } catch (NumberFormatException | BonusException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateLimitTime() {
        while (true) {
            try {
                System.out.println("Nhập vào kì hạn: ");
                int limit = Integer.parseInt(SCANNER.nextLine());

                if (limit < 0) {
                    throw new LimitTimeException("Kì hạn không hợp lệ!");
                }
                return limit;

            } catch (NumberFormatException | LimitTimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
