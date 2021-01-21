package labuladongAlgorithm.动态规划2;

import java.util.Arrays;

/**
 * @author aviccii 2021/1/21
 * @Discrimination
 */
public class 最长递增子序列 {
    /**
     * 子序列非子串，不要求连续
     * @param nums
     * @return 最长递增子序列的长度
     */
    static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        //base case: dp数组全都初始化为1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int res = 1;
        //求最长递增子序列的长度
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
