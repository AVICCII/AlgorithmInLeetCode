package 牛客;

import java.util.*;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 10:18 2021/7/4
 */
public class NC40_两个链表生成相加链表 {
    public int[] findErrorNums(int[] nums) {
        int n2 = 0, n1 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            int val = map.getOrDefault(i, 0);
            if (val == 2) n1 = i;
            else if (val == 0) n2 = i;
        }
        return new int[]{n1, n2};
    }
}
