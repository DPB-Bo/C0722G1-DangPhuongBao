package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
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

    public static void main(String[] args) {
//        System.out.println("Mảng thứ 1: ");  CÁCH GỘP 2 MẢNG
//        Integer[] arr1 = createArray(sizeArray());
//        System.out.println("Mảng thứ 2: ");
//        Integer[] arr2 = createArray(sizeArray());
//        Integer[] arr3 = new Integer[(arr1.length + arr2.length)];
//        Integer loopTimes = Math.max(arr1.length, arr2.length);
//        for (int i = 0; i < loopTimes; i++) {
//            if (i < arr1.length) arr3[i] = arr1[i];
//            if (i < arr2.length) arr3[arr1.length + i] = arr2[i];
//        }
//        System.out.println(Arrays.toString(arr3));
        // CÁCH GỘP NHIỀU MẢNG
        System.out.print("Nhập vào số lượng mảng muốn gộp: ");
        Integer amountMergeArrays = Integer.parseInt(scanner.nextLine());
        Integer[][] arrMergeArrays = new Integer[amountMergeArrays][];
        for (int i = 0; i < arrMergeArrays.length; i++) {
            System.out.println("Nhập vào mảng thứ " + (i + 1));
            arrMergeArrays[i] = createArray(sizeArray());
        }
        Integer loopTimes = arrMergeArrays[0].length;
        Integer lengthMergeArrays = 0;
        for (int i = 0; i < arrMergeArrays.length; i++) {
            lengthMergeArrays += arrMergeArrays[i].length;
        }
        Integer[] resultArrays = new Integer[lengthMergeArrays];
        for (int i = 0; i < arrMergeArrays.length; i++) {
            if (loopTimes < arrMergeArrays[i].length) loopTimes = arrMergeArrays[i].length;
        }
        int indexCount = 0;
        for (int i = 0; i < loopTimes; i++) {
            for (Integer j = 0; j < arrMergeArrays.length; j++) {
                if (i < arrMergeArrays[j].length) {
                    resultArrays[i + indexCount] = arrMergeArrays[j][i];
                }
                indexCount += arrMergeArrays[j].length;
            }
            indexCount = 0;
        }
        System.out.println(Arrays.toString(resultArrays));
    }
}
