package 左程云.排序;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.awt.geom.QuadCurve2D;
import java.util.Queue;

/**
 * @author aviccii 2021/6/18
 * @Discrimination
 */
public class 快速排序 {

    public static void QuickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotPos = partition(arr, low, high);
            QuickSort(arr, low, pivotPos - 1);
            QuickSort(arr, pivotPos + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }


//    public static void QuickSort2(int[] arr, int low, int high) {
//    if (low<high){
//        int pivotPos = partition2(arr, low, high);
//        QuickSort2(arr,low,pivotPos - 1);
//        QuickSort2(arr,pivotPos+1,high);
//    }
//    }
//
//    static int partition2(int[] arr, int low, int high) {
//        int pivot = arr[low];
//        while (low < high) {
//            while (low < high && arr[high] >= pivot) high--;
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= pivot) low++;
//            arr[high] = arr[low];
//        }
//        arr[low] = pivot;
//        return low;
//    }


//    public static void QuickSort2(int[] arr,int low,int high){
//        if (low < high){
//            int pivotPos = partition2(arr,low,high);
//            QuickSort2(arr,low,pivotPos-1);
//            QuickSort2(arr,pivotPos+ 1,high);
//        }
//    }
//
//    public static int partition2(int[] arr, int low,int high){
//        int pivot = arr[low];
//        while (low < high){
//            while (low < high && arr[high] >= pivot) high --;
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= pivot) low ++;
//            arr[high] = arr[low];
//        }
//        arr[low] = pivot;
//        return low;
//    }

    public static void QuickSort2(int[] arr,int left,int right){
        if (left< right){
            int pivotPos = partition3(arr,left,right);
            QuickSort2(arr,left,pivotPos-1);
            QuickSort2(arr,pivotPos+1,arr.length-1);
        }
    }
    static int partition3(int[] arr,int left,int right){
        int pivot = arr[left];
        while (left<right){
            while (left< right &&arr[right]>pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
 }

