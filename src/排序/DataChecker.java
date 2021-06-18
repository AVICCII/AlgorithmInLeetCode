package 排序;



import 左程云.排序.快速排序;
import 左程云.排序.计数排序;

import java.util.Arrays;
import java.util.Random;


/**
 * @author aviccii 2021/6/16
 * @Discrimination
 */
public class DataChecker {
    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(10000);

        return arr;
    }

    static void check() {
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);

        Arrays.sort(arr);
//        arr2 = 归并排序.MergeSort3(arr2);
        快速排序.QuickSort2(arr2,0,arr2.length-1);
//        计数排序.CountingSort2(arr2);


        boolean same = true;

        for (int i = 0; i < arr2.length; i++) {
            if (arr[i] != arr2[i]) {
                same = false;
                break;
            }
        }

        System.out.println(same ? "right":"wrong");
    }

    public static void main(String[] args) {
        check();
    }
}
