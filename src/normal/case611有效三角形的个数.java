package normal;

import java.util.Arrays;

/**
 * @author aviccii 2021/8/4
 * @Discrimination 2234 223 234 234
 */
public class case611有效三角形的个数 {
    public static int triangleNumber(int[] nums) {
        int res = 0;

        Arrays.sort(nums);
        int len = nums.length;

        int left = 0, right = 1;
        while (left < right && left < len && right < len - 1) {

            int pos = len - 1;
            while (nums[pos] >= (nums[left] + nums[right]) && pos > right) pos--;
            if (nums[pos] < nums[left] + nums[right]) {
                res += pos - right ;
            }
            right++;
            if (right == len - 1) {
                left++;
                right = left + 1;
            }
        }

        return res;
    }

    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        triangleNumber(new int[]{2, 2, 3, 4});
    }
}
