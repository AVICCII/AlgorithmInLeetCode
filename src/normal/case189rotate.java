package normal;

/**
 * @author aviccii 2021/1/8
 * @Discrimination 翻转数组
 */
public class case189rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = 0;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int nums[], int k) {
        for (int i = 0; i < k; i++) {
            for (int length = nums.length; length > 0; length--) {
                int temp = nums[length-1];
                nums[length]=nums[length-1];
                nums[length-1] = temp;
            }
        }
    }
}
