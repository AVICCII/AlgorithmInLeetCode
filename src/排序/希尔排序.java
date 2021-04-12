package 排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/3/30
 * @Discrimination
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        int gap = len / 2;

        while (gap > 0) {

            for (int i = gap; i < array.length ; i++) {
                int index = i-gap;
                int tempVal = array[i];
                while (index>=0 && array[index]>tempVal){
                    array[index + gap] =array[index];
                    index -= gap;
                }
                array[index+gap] = tempVal;
            }


            gap /= 2;
        }


        return array;
    }
}
