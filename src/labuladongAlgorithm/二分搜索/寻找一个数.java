package labuladongAlgorithm.二分搜索;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 寻找一个数 {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;//注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }
}
