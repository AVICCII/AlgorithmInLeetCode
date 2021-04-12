package labuladongAlgorithm.二分搜索;

/**
 * @author aviccii 2021/1/18
 * @Discrimination
 */
public class 寻找右侧边界的二分搜索 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5,6,7,8,9,10};
        System.out.println(right_bound(test, 4));
    }

    public static int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;//注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid ;
            }
        }
        return left - 1;
    }

    int right_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }
        return right - 1;
    }

    public static int right_bound3(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
        }
        if (right < 0 || nums[right] != target) return -1;
        else return right;
    }
}
