package SGGAlogrithmDS.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author aviccii 2020/11/10
 * @Discrimination
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101,35,33,32,31,34};
        insertSort(arr);
        System.out.println("result =>"+Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int flagVal = arr[i];
            int flag=i-1;
            while (flag>=0 && flagVal<arr[flag]){
                arr[flag+1] = arr[flag];
                flag--;
                System.out.println(Arrays.toString(arr));
                System.out.println();
            }
            arr[flag+1] = flagVal;
            System.out.println("单次遍历"+Arrays.toString(arr));
        }
    }
}
