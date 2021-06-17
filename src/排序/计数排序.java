package 排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/5/19
 * @Discrimination
 */
public class 计数排序 {
    public static int[] countingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        //找出最小值和最大值
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        //偏差
        bias = 0 - min;
        //新开辟一个数组
        int[] bucket = new int[max - min + 1];
        //数据初始化为0
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias] += 1;
        }

        int index = 0;
        for (int i = 0;i<bucket.length;i++){
            int len = bucket[i];
            while (len > 0){
                array[index++] = i -bias;
                len --;
            }
        }
        return array;
    }
}
