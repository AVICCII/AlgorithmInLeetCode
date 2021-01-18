package labuladongAlgorithm.左右指针;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 两数之和 {
    int[] twoSum(int[] nums, int target) {
        //左右指针在数组两端初始化
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                //题目要求的索引是从1开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;//让sum增加
            } else if (sum > target) {
                right--;//让sum缩小
            }
        }
        return new int[]{-1, -1};
    }
}
