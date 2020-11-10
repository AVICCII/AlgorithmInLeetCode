package SGGAlogrithmDS.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author aviccii 2020/11/10
 * @Discrimination
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void ShellSort(int[] arr) {

        int temp = 0;
        for (int gap = arr.length/2;gap>0;gap/=2){
            //希尔排序
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组,每组arr.length/gap个元素），步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }
}
