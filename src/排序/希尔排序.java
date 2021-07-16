package 排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/3/30
 * @Discrimination
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        int gap = len / 2;

        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int index = i - gap;
                int tempVal = array[i];
                while (index >= 0 && tempVal < array[index]) {
                    array[index + gap] = array[index];
                    index -= gap;
                }
                array[index + gap] = tempVal;
            }

            gap /= 2;
        }
        return array;
    }


    public static int[] shellSort2(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = 0; i < arr.length - gap; i++) {
                int index = i;
                int cur = arr[index + gap];
                while (index >= 0 && cur < arr[index]) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                arr[index + gap] = cur;
            }
            gap /= 2;
        }
        return arr;
    }
}
