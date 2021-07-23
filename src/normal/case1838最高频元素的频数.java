package normal;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/19
 * @Discrimination
 */
public class case1838最高频元素的频数 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0,res = 1;
        long total = 0;
        for (int right = 1; right < len; right++) {
            total += (nums[right] - nums[right - 1])*(right - left);
            while (total > k){
                total -= nums[right] - nums[left];
                ++ left;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
