package Array;

/**
 * @author aviccii 2020/9/7
 * @Discrimination  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class rotate {
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }



    public static void main(String[] args) {
        int[] a= new int[]{1,2,3,4,5,6,7};
        rotate(a,3);
    }


    /**
     * 更优解：多次反转
     * 时间复杂度为O(n)
     */
    public class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

}
