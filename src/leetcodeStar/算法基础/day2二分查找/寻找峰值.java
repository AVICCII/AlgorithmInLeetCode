package leetcodeStar.算法基础.day2二分查找;

/**
 * @author aviccii 2021/7/22
 * @Discrimination
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }

    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) return search(nums, left, mid - 1);
        return search(nums, mid + 1, right);
    }

    public int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
