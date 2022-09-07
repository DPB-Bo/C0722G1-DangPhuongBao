package test_sth.test_java_work;

import java.util.Arrays;

public class TestSwapItem {
    public static Integer[] swapItems(Integer indexAddItem, Integer[] array) {
        for (int i = 4; i > 1; i--) {
            array[i] = array[i - 1] - ((array[i - 1] = array[i]) - array[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 5, -1, 2};
//        arr = swapItems(1, arr);
        System.out.println(Arrays.toString(swapItems(1, arr)));
    }
}
