package ss1_introduction_to_java.exercises;

import java.util.Scanner;

public class TransferVNDAndUSD {
    public static void main(String[] args) {
        int typeTransfer;
        String result;
        float moneyAmount;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chọn hình thức chuyển đổi: ");
            System.out.println("Nhấn 1 để VND sang USD và 0 để USD sang VND :");
            typeTransfer = scanner.nextInt();
        } while (typeTransfer != 1 && typeTransfer != 0);
        do {
            System.out.println("Nhập số tiền hợp lệ cần chuyển đổi: ");
            moneyAmount = scanner.nextFloat();
        } while (moneyAmount <= 0);
        result = typeTransfer == 1 ? moneyAmount / 23000 + "USD" : moneyAmount * 23000 + "VND";
        System.out.println("Kết quả là : " + result);
    }
}
