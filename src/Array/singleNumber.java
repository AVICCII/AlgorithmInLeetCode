package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aviccii 2020/9/7
 * @Discrimination      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */

/**
 * 异或求解
 *
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
