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

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            int current = array[index+1];
            while (index>=0&&array[index]>current){
                array[index+1]=array[index];
                index--;
            }
            array[index+1] = current;
        }

        return array;
    }

    public static int[] insertSort2(int[] arr){
        if (arr.length == 0) return null;

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int cur = arr[index+1];
            while (index>=0 && cur<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = cur;
        }
        return arr;
    }

}
