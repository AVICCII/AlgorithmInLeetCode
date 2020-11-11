package SGGAlogrithmDS.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author aviccii 2020/11/11
 * @Discrimination
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23,23, -567, 70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让比pivot小的放在左，大的放在右
        while (l < r) {
            //在pivot左边一直找，找到比他大的退出while
            //这里不加等于，如果有序，则找到pivot本身作为结束
            while (arr[l] < pivot) {

                l += 1;
            }

            //在pivot右边一直找，找到比他小的退出while
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果下式成立，说明pivot左右两边的值已经按照左小右大的顺序排列
            if (l >= r) {
                System.out.println("跳");
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 47-59 有点绕
            //如果交换完成，发现arr[l] == pivot值 相等 r--，前移
            if (arr[l] == pivot) {
                System.out.println("左移交换");
                r -= 1;
            }

            //如果交换完成，发现arr[r] == pivot值 相等 l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }
            System.out.println(Arrays.toString(arr));
        }

        //base if l==r, must l++,r--1, else stack overflow
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left<r) quickSort(arr,left,r);
        //向右递归
        if (right>l) quickSort(arr,l,right);
    }
}
