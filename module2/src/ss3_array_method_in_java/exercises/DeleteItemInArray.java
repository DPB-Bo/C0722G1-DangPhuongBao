package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteItemInArray {
    static Scanner scanner = new Scanner(System.in);

    public static Integer[] createArray(Integer sizeArray) {
        Integer[] arr = new Integer[sizeArray];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
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

    public static void swapItems(Integer index, Integer[] array) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1] - (array[i + 1] = array[i]) - array[i];
        }
    }

    public static void main(String[] args) {
        Integer[] arrNumbers = createArray(sizeArray());
        System.out.println("Mảng ban đầu: " + Arrays.toString(arrNumbers));
        System.out.print("Nhập vào phần tử cần xoá: ");
        int deleteNumber = Integer.parseInt(scanner.nextLine());
        int countDeleteTimes = 0;
        for (int i = 0; i < arrNumbers.length; i++) {
            if (arrNumbers[i] == deleteNumber) {
                arrNumbers[i] = 0;
                swapItems(i, arrNumbers);
                i--;
                countDeleteTimes++;
            }
        }
        if (countDeleteTimes < 1) {
            System.out.println("Không có phần tử cần xoá trong mảng.Mảng giữ nguyên: " + Arrays.toString(arrNumbers));
        } else {
            System.out.printf("Mảng sau khi xoá phần tử %d là: %s", deleteNumber, Arrays.toString(arrNumbers));
        }
    }
}
