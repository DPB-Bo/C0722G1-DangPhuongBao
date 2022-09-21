package algorithm;

import java.util.*;

public class Week3 {
    public static String haha(String str) {
        String rangeID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        for (int i = 1; i < list.size(); i++) {
            if (rangeID.contains(list.get(i))) {
                list.set(i, " " + list.get(i));
            }
        }
        return String.join("", list).toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();
        System.out.println("Chuỗi ban đầu :" + str);
        System.out.println("Chuỗi chuyển đổi :" + haha(str));
    }
}
