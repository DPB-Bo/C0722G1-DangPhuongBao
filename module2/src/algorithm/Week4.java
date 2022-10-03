package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Week4 {
    public static int[] solution(int[] arr) {
        int pos, x;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            x = arr[i];
            pos = i;
            while (pos > 0) {
                if (arr[pos] != -1 && x < arr[pos]) {
                    arr[pos] = arr[pos - 1];
                }
                pos--;
            }
            arr[pos] = x;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 150, 190, 170, -1, -1, 160, 180};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
