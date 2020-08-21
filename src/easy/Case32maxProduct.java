package easy;

/**
 * @author aviccii 2020/8/21
 * @Discrimination 数组最大两个数相乘
 */
public class Case32maxProduct {
    public int maxProduct(int[] nums) {
        int big = 0;
        int big2 = -1;
        for (int num : nums) {
            if (num > big) {
                big = num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
                if (nums[i] == big) {
                    nums[i] = 0;
                    break;
                }
            }
            for (int i : nums) {
                if (i > big2) {
                    big2 = i;
                }
            }
            return (big - 1) * (big2 - 1);
    }
}
