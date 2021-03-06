package labuladongAlgorithm.二分搜索;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class  寻找左侧边界的二分搜索 {


    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;  //注意

        while (left < right) {//注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid ;//注意
            }
        }
        return left;
    }

    int left_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        //检查数组越界
        if (left >=nums.length|| nums[left]!=target) return -1;
        return right;
    }
}
