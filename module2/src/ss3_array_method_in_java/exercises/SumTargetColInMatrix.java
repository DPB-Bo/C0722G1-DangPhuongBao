package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class SumTargetColInMatrix {
    static Scanner scanner = new Scanner(System.in);

    public static Integer[] createArray(Integer sizeArray) {
        Integer[] arr = new Integer[sizeArray];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        return arr;
    }

    public static Integer sizeArray(int amountDArrays) {
        int sizeArray;
        do {
            System.out.printf("Nhập vào độ dài của mảng %d chiều: ", amountDArrays);
            sizeArray = Integer.parseInt(scanner.nextLine());
            if (sizeArray < 1) System.out.println("Vui lòng nhập độ dài hợp lệ!");
        } while (sizeArray < 1);
        return sizeArray;
    }

    public static void displayTwoDimensionalArray(Integer[][] arr) {
        System.out.print("Mảng 2 chiều vừa nhập là: ");
        for (Integer[] item : arr) {
            System.out.print(Arrays.toString(item));
        }
        System.out.print("\n");
    }

    public static Integer[][] createTwoDimensionalArray() {
        Integer amountChildArrays = sizeArray(2);
        Integer[][] arrTwoDimensional = new Integer[amountChildArrays][];
        for (int i = 0; i < arrTwoDimensional.length; i++) {
            System.out.println("Nhập vào mảng thứ " + (i + 1));
            arrTwoDimensional[i] = createArray(sizeArray(1));
        }
        return arrTwoDimensional;
    }

    public static void main(String[] args) {
        Integer[][] matrix = createTwoDimensionalArray();
        displayTwoDimensionalArray(matrix);
        int colSum;
        do {
            System.out.printf("Nhập vào cột muốn tính tổng (mảng có %d cột) :", matrix.length);
            colSum = Integer.parseInt(scanner.nextLine());
            if (colSum < 1 || colSum >= matrix.length) System.out.print("\nCột không tồn tại, xin nhập lại!");
        } while (colSum < 1 || colSum >= matrix.length);
        int sumCol = 0;
        for (Integer[] item : matrix) {
            sumCol += item[colSum - 1];
        }
        System.out.printf("Tổng phần tử trong cột đã chọn là: %d", sumCol);
    }
}
