package easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author aviccii 2020/11/6
 * @Discrimination 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 */
public class Case44sortByBits {

    public static void main(String[] args) {
//      int i =7;
//        int count = Integer.bitCount(i);
//        System.out.println(count);
        int[] arr = {0,1,2,3,4,5,6,7,8};
        sortByBits(arr);

        //[1, 2, 4, 8, 3, 5, 6, 7, 11]

        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortByBits(int[] arr) {

        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
            bit[i]= Integer.bitCount(i);
        }

        list.sort((x,y) ->{
            if (bit[x] != bit[y]) return bit[x] - bit[y];
            return x-y;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }

    return arr;
    }
}
