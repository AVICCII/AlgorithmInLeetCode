package normal;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/14
 * @Discrimination
 */
public class case1818_绝对差数和 {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;

        if (Arrays.equals(nums1, nums2)) return 0;

        int[] memo = new int[nums1.length];
        System.arraycopy(nums1, 0, memo, 0, nums1.length);
        Arrays.sort(memo);

        int absSum = 0, maxVal = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            absSum =  (absSum+diff)  % MOD;
            int testPos = binarySearch(memo, nums2[i]);
            //检查j位置
            if (testPos < nums1.length) maxVal = Math.max(maxVal, diff - (memo[testPos] - nums2[i]));
            //检查j-1位置(因为二分得到的数可能不是最接近的，如果是连续数可能是旁边的数)
            if (testPos > 0) maxVal = Math.max(maxVal, diff - (nums2[i] - memo[testPos - 1]));
        }

        return (absSum - maxVal + MOD) % MOD;
    }

    public static int binarySearch(int[] memo, int target) {
        int low = 0, high = memo.length - 1;
        if (memo[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (memo[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int nums1[] = {1, 10, 4, 4, 2, 7};
        int nums2[] = {9, 3, 5, 1, 7, 4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }
}
