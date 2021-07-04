package 左程云.排序;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import javax.imageio.stream.ImageInputStream;
import java.awt.geom.QuadCurve2D;
import java.util.Queue;

/**
 * @author aviccii 2021/6/18
 * @Discrimination
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        QuickSort4(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void QuickSort(int[] arr, int low, int high) {

        //
        if (low < high) {
            int pivotPos = partition(arr, low, high);
            QuickSort(arr, low, pivotPos - 1);
            QuickSort(arr, pivotPos + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //精简写法
            //从后往前找到比基准小的数，如果没找到说明到low位置前都满足了比pivot大的要求
            while (low < high && arr[high] >= pivot) --high;
            //如果找到了，那么这里将低位比基准大的数换成高位比基准小的数，如果没找到，这里low=high,等于未作处理(本身有序无需处理)
            arr[low] = arr[high];
            //从前往后找比基准大的数，如果没找到说明high位置前都满足了比pivot小的要求
            while (low < high && arr[low] <= pivot) ++low;
            //找到了，那么之前比pivot小的高位数就换成这里的比基准值大的低位数，此时还没查找完的情况下(low<high),再去39行找比基准值小的数，
            //如果找到了，41行将低位比基准大的数(也就是这里的arr[low])换成高位比基准小的数。如此循环往复
            //这里没找到那么low=high，等于未作处理。程序无论如何到这里，arr[low]的值都是待更新的状态
            arr[high] = arr[low];
        }
        //在跳出循环后第一步就是对arr[low]赋值，这里low==high，因此左右都有序了，而这个临界点需要将基准赋值进去
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

//    public static void QuickSort2(int[] arr,int left,int right){
//        if (left< right){
//            int pivotPos = partition3(arr,left,right);
//            QuickSort2(arr,left,pivotPos-1);
//            QuickSort2(arr,pivotPos+1,arr.length-1);
//        }
//    }
//    static int partition3(int[] arr,int left,int right){
//        int pivot = arr[left];
//        while (left<right){
//            while (left< right &&arr[right]>pivot) right--;
//            arr[left] = arr[right];
//            while (left < right && arr[left] < pivot) left++;
//            arr[right] = arr[left];
//        }
//        arr[left] = pivot;
//        return left;
//    }

    public static void QuickSort4(int[] arr,int left,int right){
       if (left < right){
           int pos = partition4(arr,left,right);
           QuickSort4(arr,left,pos-1);
           QuickSort4(arr,pos+1,arr.length - 1);
       }
    }

    private static int partition4(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right){
            while (left < right && arr[right] > pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < pivot) left ++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}

