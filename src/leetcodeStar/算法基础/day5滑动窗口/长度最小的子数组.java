package leetcodeStar.算法基础.day5滑动窗口;

import java.util.List;
import java.util.Scanner;

/**
 * @author aviccii 2021/8/2
 * @Discrimination
 */
public class 长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum  = 0;
        while (left <= right && left < len && right < len){
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right ++;
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }


    public static void main(String[] args) {
    }
}
