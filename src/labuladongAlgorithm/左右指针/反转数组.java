package labuladongAlgorithm.左右指针;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 反转数组 {
    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //交换nums[left]和nums[right]
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
