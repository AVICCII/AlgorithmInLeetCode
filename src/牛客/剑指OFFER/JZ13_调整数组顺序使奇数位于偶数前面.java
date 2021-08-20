package 牛客.剑指OFFER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/8/3
 * @Discrimination
 */
public class JZ13_调整数组顺序使奇数位于偶数前面 {
    public int[] reOrderArray (int[] array) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for (int i : array) {
            if (i % 2 == 0) two.add(i);
            else one.add(i);
        }
        one.addAll(two);

        int[] res = new int[one.size()];

        for (int i = 0; i < one.size(); i++) {
            res[i] = one.get(i);
        }
        return res;
    }
}
