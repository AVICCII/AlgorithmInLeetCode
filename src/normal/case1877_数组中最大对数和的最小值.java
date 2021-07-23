package normal;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/20
 * @Discrimination
 */
public class case1877_数组中最大对数和的最小值 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = len / 2; i < len; i++) {
            res = Math.max(res, nums[i] + nums[len - i - 1]);
        }
        return res;
    }
}
