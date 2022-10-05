package case_study.utils.validate;

import case_study.utils.exception.person_exception.customer_exception.AddressException;
import case_study.utils.exception.person_exception.customer_exception.RankException;

import java.util.Scanner;

public class CustomerValidate {
    private final String[] rankList = {"Diamond", "Platinum", "Gold", "Silver", "Member"};
    private final Scanner SCANNER = new Scanner(System.in);

    public String validateRank() {
        while (true) {
            try {
                System.out.println("Các loại khách hàng hiện có: Diamond,Platinum,Gold,Silver,Member");
                System.out.print("Nhập vào loại khách hàng: ");
                String tempRank = SCANNER.nextLine();
                for (String rank : rankList) {
                    if (rank.equals(tempRank)) {
                        return tempRank;
                    }
                }
                throw new RankException("Loại khách hàng không hợp lệ!");
            } catch (RankException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateAddress() {
        while (true) {
            try {
                System.out.print("Nhập vào địa chỉ của khách hàng: ");
                String tempAddress = SCANNER.nextLine();
                if (tempAddress.length() < 1) {
                    throw new AddressException("Vui lòng nhập địa chỉ");
                }
                return tempAddress;
            } catch (AddressException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
