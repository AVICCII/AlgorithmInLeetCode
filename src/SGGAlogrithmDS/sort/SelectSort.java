package SGGAlogrithmDS.sort;

import java.util.Arrays;

/**
 * @author aviccii 2020/11/6
 * @Discrimination
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 1, -3, 4, 0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length-1; j++) {
            int min = arr[j];
            int index = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[i]<=min){
                    min = arr[i];
                    index = i;
                }
            }
            arr[index]=arr[j];
            arr[j]=min;
        }
    }

}
