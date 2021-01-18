package labuladongAlgorithm.二分搜索;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 寻找右侧边界的二分搜索 {
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;//注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            }
        }
        if (right<0|| nums[right] != target)return -1;
        return right;
    }
}
