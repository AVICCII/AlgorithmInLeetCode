package 动态规划;

import java.util.Arrays;

/**
 * @author aviccii 2021/4/6
 * @Discrimination
 */
public class 最小递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化dp,因为每个元素最小的递增子序列是本身,因此设置为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) dp[j] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int lengthOfLIS2(int[] nums){
        int[] top = new int[nums.length];
        //牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            //要处理的扑克牌
            int poker = nums[i];

            //搜索左侧边界的二分查找
            int left = 0,right = piles;
            while (left < right){
                int mid = (left+right)/2;
                if (top[mid]>poker) right = mid;
                else if (top[mid]<poker) left = mid +1;
                else right = mid;
            }
            //--------------------------------//

            //没找到合适的牌堆,新建一堆
            if (left == piles) piles++;
            //把这张牌放到牌堆顶
            top[left] = poker;
        }

        //牌堆数就是LIS长度
        return piles;
    }
}
