package 左程云.排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/6/17
 * @Discrimination
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

//    public static void sort(int[] arr,int left,int right) {
//        if (left == right) return;
//        //分成两半
//        int mid = left + (right - left)/2;
//        //排序左边
//        sort(arr,left,mid);
//        //排序右边
//        sort(arr,mid+1,right);
//        merge(arr,left,mid+1,right);
//    }
//
//    static void merge(int[] arr,int left,int right,int rightBound) {
//        int mid = right - 1;
//        int[] temp = new int[rightBound-left + 1];
//
//        int i = left;//前半段指针
//        int j = right;//后半段指针
//        int k = 0;//指在temp的位置上
//
//        while (i <= mid && j <= rightBound) {
//            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
//        }
//
//        while (i <= mid) temp[k++] = arr[i++];
//        while (j <= rightBound) temp[k++] = arr[j++];
//
//        for (int m = 0; m < temp.length; m++) {
//            arr[left+m]= temp[m];
//        }
//    }

    public static int[] MergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));

    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] <= right[j]) {
                result[index] = left[i++];
            } else {
                result[index] = right[j++];
            }
        }
        return result;
    }


//    public static int[] MergeSort2(int[] arr) {
//        if (arr.length < 2) return arr;
//        int mid = arr.length / 2;
//        int[] left = Arrays.copyOfRange(arr, 0, mid);
//        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
//        return merge2(MergeSort2(left), MergeSort2(right));
//    }
//
//    public static int[] merge2(int[] left, int[] right) {
//        int[] res = new int[left.length + right.length];
//        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
//            if (i >= left.length) res[index] = right[j++];
//            else if (j >= right.length) res[index] = left[i++];
//            else if (left[i] > right[j]) res[index] = right[j++];
//            else res[index] = left[i++];
//        }
//        return res;
//    }


    public static int[] MergeSort3(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge3(MergeSort3(left), MergeSort3(right));
    }

    static int[] merge3(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) res[index] = right[j++];
            else if (j >= right.length) res[index] = left[i++];
            else if (left[i] < right[j]) res[index] = left[i++];
            else res[index] = right[j++];
        }
        return res;
    }
}
