package 左程云.超级水王;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/6/21
 * @Discrimination
 */
public class EzImpl {
    //简单解法，不符合超级水王要求
    public static int verify(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int N = arr.length;
        for (Map.Entry<Integer, Integer> record : map.entrySet()) {
            if (record.getValue() > (N >> 1)) return record.getKey();
        }
        return -1;
    }

    //利用有限次和不使用额外空间的真实超级水王实现
    public static int RealImp(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int candidate = 0;
        int val = 0;
        for (int cur : arr) {
            //如果没有候选
            if (val == 0) {
                candidate = cur;
                val = 1;
            } else if (cur != candidate) val--;//如果有候选，且当前数字和候选不一样
            else val++;//如果有候选且当前数字与候选相同
        }

        //如果遍历完成后，没有候选数留下，说明没有水王数
        if (val == 0) return -1;

        //如果有候选留下来，再去遍历一遍，得到候选真正出现的次数
        int count = 0;
        for (int i : arr) {
            if (i == candidate) count++;
        }
        int N = arr.length;
        return count > (N >> 1) ? candidate : -1;
    }

//    public static int test(int[] arr) {
//        if (arr == null || arr.length == 0) return -1;
//        int candidate = 0;
//        int val = 0;
//        for (int i : arr) {
//            if (val == 0) {
//                candidate = i;
//                val = 1;
//            } else if (candidate == i) val++;
//            else val--;
//        }
//        if (val == 0) return -1;
//        int count = 0;
//        for (int i : arr) {
//            if (i == candidate) count++;
//        }
//        int N = arr.length;
//        return count > (N >> 1) ? candidate : -1;
//    }
}
