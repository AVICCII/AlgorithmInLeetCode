package labuladongAlgorithm.左右指针;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 二分搜索 {
    int binarySearch(int[] nums, int target) {
        //左右指针在数组的两端初始化
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//防止溢出
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }
}
