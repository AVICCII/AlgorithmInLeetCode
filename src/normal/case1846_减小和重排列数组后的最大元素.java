package normal;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/15
 * @Discrimination
 */
public class case1846_减小和重排列数组后的最大元素 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }

    public static void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            QuickSort(arr, left, partition - 1);
            QuickSort(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && pivot <= arr[right]) right--;
            arr[left] = arr[right];
            while (left < right && pivot >= arr[left]) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return pivot;
    }

}
