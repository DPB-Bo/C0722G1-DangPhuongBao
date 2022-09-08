package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class AddItemToArray {
    static Scanner scanner = new Scanner(System.in);

    public static Integer[] createArray(Integer indexInputTo, Integer sizeArray) {
        Integer[] arr = new Integer[sizeArray];
        for (int i = 0; i < indexInputTo; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = indexInputTo; i < arr.length; i++) {
            arr[i] = -1;
        }
        return arr;
    }

    public static Integer sizeArray() {
        Integer sizeArray = -1;
        do {
            System.out.print("Nhập vào độ dài của mảng: ");
            sizeArray = Integer.parseInt(scanner.nextLine());
            if (sizeArray < 1) System.out.println("Vui lòng nhập độ dài hợp lệ!");
        } while (sizeArray < 1);
        return sizeArray;
    }

    public static Integer[] addItemToArray(Integer[] arr) {
        int indexAddItem;
        do {
            System.out.print("Nhập vào vị trí muốn chèn: ");
            indexAddItem = Integer.parseInt(scanner.nextLine());
            if (indexAddItem < 0 || indexAddItem >= arr.length) System.out.println("Vui lòng nhập vị trí hợp lệ!");
        } while (indexAddItem < 0 || indexAddItem >= arr.length);
        System.out.print("Nhập vào giá trị muốn chèn: ");
        int valueAddItem = Integer.parseInt(scanner.nextLine());
        arr[arr.length - 1] = valueAddItem;
        return swapItems(indexAddItem, arr);
    }

    public static Integer[] swapItems(Integer indexAddItem, Integer[] array) {
        for (int i = array.length - 1; i > indexAddItem; i--) {
            array[i] = array[i - 1] - ((array[i - 1] = array[i]) - array[i]);
        }
        return array;
    }

    public static void doWhenOverLength(Integer[] arrNumbers) {
        System.out.print("*****Số lượng phần tử còn trống đã hết!*****\n" +
                "1.Chèn thêm sẽ xoá phần tử cuối của mảng\n" +
                "2.Huỷ và xem lại mảng\n" +
                "3.Thoát\n" +
                "Nhập lựa chọn của bạn vào đây: ");
        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                System.out.println("Mảng sau khi đã thêm: " + Arrays.toString(addItemToArray(arrNumbers)));
                break;
            case 2:
                System.out.println(Arrays.toString(arrNumbers));
                break;
            case 3:
                System.out.println("Chương trình kết thúc!");
                System.exit(0);
            default:
                System.out.println("Không có lựa chọn này! ");
                break;
        }
    }

    public static void main(String[] args) {
        Integer sizeArray = sizeArray();
        System.out.print("Số lượng phần tử muốn nhập vào: ");
        int inputIndexTo = Integer.parseInt(scanner.nextLine());
        Integer[] arrNumbers = createArray(inputIndexTo, sizeArray);
        System.out.println("*****Các phần tử còn thiếu của mảng sẽ được chèn -1 *****");
        Integer choice;
        do {
            System.out.print("Menu:\n" +
                    "1.Thêm (chèn) phần tử\n" +
                    "0.Thoát\n" +
                    "Nhập lựa chọn của bạn vào đây: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                default:
                    System.out.println("Không có lựa chọn này! ");
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc!");
                    System.exit(0);
                case 1:
                    boolean isNotOverLength = inputIndexTo < arrNumbers.length;
                    if (isNotOverLength) {
                        System.out.println("Mảng sau khi đã thêm: " + Arrays.toString(addItemToArray(arrNumbers)));
                        inputIndexTo++;
                    } else {
                        doWhenOverLength(arrNumbers);
                    }
                    break;
            }
        } while (true);
    }
}