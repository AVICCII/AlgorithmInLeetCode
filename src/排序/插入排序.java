package 排序;

/**
 * @author aviccii 2021/3/30
 * @Discrimination
 */

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {1, 1, -3, 4, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] insertSort(int[] array) {
        if (array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length -1; i++) {
            int index = i;
            int tempVal = array[i+1];
            while (index>=0 && tempVal< array[index]){
                array[index+1] = array[index];
                index -=1;
            }
            array[index+1] = tempVal;
        }

        return array;
    }
}
