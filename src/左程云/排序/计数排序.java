package 左程云.排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/6/18
 * @Discrimination
 */
public class 计数排序 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 11, 1, 2, 4, 5, 8};
        CountingSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

//
//    public static int[] countingSort(int[] arr) {
//        if (arr.length == 0) return arr;
//        int bias, min = arr[0], max = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min) min = arr[i];
//            if (arr[i] > max) max = arr[i];
//        }
//        bias = -min;
//        int[] bucket = new int[max - min + 1];
//        Arrays.fill(bucket, 0);
//        for (int i = 0; i < arr.length; i++) {
//            bucket[arr[i] + bias] += 1;
//        }
//
//        int index = 0;
//        for (int i = 0; i < bucket.length; i++) {
//            int len = bucket[i];
//            while (len > 0) {
//                arr[index++] = i - bias;
//                len--;
//            }
//        }
//        return arr;
//    }

    public static int[] CountingSort2(int[] arr) {
        if (arr.length == 0) return arr;
        int bias, min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }
        bias = -min;
        int[] pos = new int[max - min + 1];
        Arrays.fill(pos,0);
        for (int i = 0; i < arr.length; i++) {
            pos[arr[i] + bias] += 1;
        }
        int index = 0;
        for (int i = 0; i < pos.length; i++) {
            int len = pos[i];
            while (len > 0){
                arr[index++] = i - bias;
                len--;
            }
        }
        return arr;
    }

    public static int[] CountingSort3(int[] arr){
        if (arr.length == 0) return arr;
        int bias, min =arr[0],max =arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max = arr[i];
            if (arr[i]<min) min = arr[i];
        }
        bias = -min;
        int[] pos = new int[max - min + 1];
        Arrays.fill(pos,0);
        for (int i = 0; i < arr.length; i++) {
            pos[arr[i] + bias] += 1;
        }
        for (int i = 0,index = 0;i< pos.length;i++){
            int len = pos[i];
            while (len> 0){
                arr[index++] = i - bias;
                len --;
            }
        }
        return arr;
    }
}
