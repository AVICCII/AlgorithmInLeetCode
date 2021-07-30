package leetcodeStar.算法基础.day5滑动窗口;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/29
 * @Discrimination
 */
public class 乘积小于k的子数组 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{10, 5, 2,6}, 100);
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2,6}, 0));
    }
}
