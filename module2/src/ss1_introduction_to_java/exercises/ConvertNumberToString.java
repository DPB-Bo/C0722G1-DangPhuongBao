package ss1_introduction_to_java.exercises;

import java.util.Scanner;

public class ConvertNumberToString {
    String[][] numberToString = {
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"KHÔNG ", "MỘT ", "HAI ", "BA ", "BỐN ", "NĂM ", "SÁU ", "BẢY ", "TÁM ", "CHÍN "}
    };

    String result;

    public String oneNumber(String randomNumber) {
        for (int i = 0; i < numberToString[0].length; i++) {
            if (randomNumber.equals(numberToString[0][i])) {
                result = numberToString[1][i];
                break;
            }
        }
        return result;
    }

    public String finalNumber(String randomNumber, Integer lengthRandomNumber) {
        String result = "";
        String lastNumber = Character.toString(randomNumber.charAt(lengthRandomNumber - 1));
        String secondNumber = Character.toString(randomNumber.charAt(lengthRandomNumber - 2));
        boolean secondNumberIsOne = secondNumber.equals("1");
        boolean lastNumberIsZero = lastNumber.equals("0");
        boolean lastNumberIsOne = lastNumber.equals("1");
        boolean lastNumberIsFive = lastNumber.equals("5");
        for (int j = 0; j < numberToString[0].length; j++) {
            if (lastNumber.equals(numberToString[0][j])) {
                if (lastNumberIsZero) {
                    return result;
                } else if (lastNumberIsOne && secondNumberIsOne) {
                    return result = "MỘT ";
                } else if (lastNumberIsOne) {
                    return result = "MỐT ";
                } else if (lastNumberIsFive) {
                    return result = "LĂM ";
                } else {
                    return result = numberToString[1][j];
                }
            }
        }
        return result;
    }

    public String secondNumber(String randomNumber, Integer lengthRandomNumber) {
        String result = "";
        String secondNumber = Character.toString(randomNumber.charAt(lengthRandomNumber - 2));
        for (int j = 0; j < numberToString[0].length; j++) {
            if (secondNumber.equals(numberToString[0][j])) {
                if (secondNumber.equals("1")) {
                    if (secondNumber.equals("0")) {
                        return result = "MƯỜI ";
                    } else {
                        result = "MƯỜI ";
                    }
                } else {
                    result = numberToString[1][j] + "MƯƠI ";
                }
            }
        }
        return result;
    }

    public String twoNumber(String randomNumber) {
        result += secondNumber(randomNumber, 2);
        result += finalNumber(randomNumber, 2);

        return result;
    }

    public String threeNumber(String randomNumber) {
        boolean secondIsZero = Character.toString(randomNumber.charAt(1)).equals("0");
        boolean thirdIsZero = Character.toString(randomNumber.charAt(2)).equals("0");
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(0)).equals(numberToString[0][j])) {
                result = numberToString[1][j] + "TRĂM ";
            }
        }
        if (secondIsZero && thirdIsZero) {
            return result;
        }
        result += secondNumber(randomNumber, 3);
        result += finalNumber(randomNumber, 3);
        return result;
    }

    public static void main(String[] args) {
        ConvertNumberToString result = new ConvertNumberToString();
        Scanner scanner = new Scanner(System.in);
        int randomNumber;
        do {
            System.out.println("Nhập và 1 số từ 1-999: ");
            randomNumber = scanner.nextInt(); // vi du ở đây muốn bắt lỗi người dùng nhập vào k phải int thì làm sao @@!
        } while (randomNumber < 0 || randomNumber > 999);
        String stringRandomNumber = Integer.toString(randomNumber);
        if (stringRandomNumber.length() == 1) System.out.println(result.oneNumber(stringRandomNumber));
        if (stringRandomNumber.length() == 2) System.out.println(result.twoNumber(stringRandomNumber));
        if (stringRandomNumber.length() == 3) System.out.println(result.threeNumber(stringRandomNumber));
    }
}
