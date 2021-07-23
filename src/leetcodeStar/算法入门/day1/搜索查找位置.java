package leetcodeStar.算法入门.day1;

/**
 * @author aviccii 2021/7/6
 * @Discrimination
 */
public class 搜索查找位置 {
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (low == high) {
                if (nums[low] != target) break;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
            if (nums[mid] == target) return mid;
        }
        if (target > nums[low]) return low + 1;
        if (target < nums[low]) return low;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
