package labuladongAlgorithm.打家劫舍;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author aviccii 2021/3/22
 * @Discrimination
 */
public class HouseRobber1 {

    private int[] memo;
    public int rob(int[] nums) {
        //初始化备忘录
         memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        //base
        if (start >= nums.length) return 0;
        //避免重复计算
        if (memo[start] != -1) return memo[start];
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;
    }
}
