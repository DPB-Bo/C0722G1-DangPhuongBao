package bank_menu.utils.validate;

import bank_menu.utils.exception.CardCodeException;
import bank_menu.utils.exception.MoneyInAccountException;

import java.util.Scanner;

public class PayAccountValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    public String validateCardCode() {
        while (true) {
            String regex = "[0-9]{16}";
            try {
                System.out.println("Nhập vào số thẻ (16 số)");
                String codeCard = SCANNER.next();

                if (!(codeCard.matches(regex))) {
                    throw new CardCodeException("Số thẻ không hợp lệ");
                }
                return codeCard;
            } catch (CardCodeException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public int validateMoneyInAccount() {
        while (true) {
            try {
                System.out.println("Nhập vào số trong tài khảon: ");
                int money = Integer.parseInt(SCANNER.nextLine());

                if (money < 0) {
                    throw new MoneyInAccountException("Sô tiền tiết kim không hợp lệ: ");
                }
                return money;
            } catch (NumberFormatException | MoneyInAccountException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
