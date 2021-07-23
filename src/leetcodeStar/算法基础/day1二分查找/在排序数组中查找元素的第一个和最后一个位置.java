package leetcodeStar.算法基础.day1二分查找;

/**
 * @author aviccii 2021/7/20
 * @Discrimination
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                left = i;
                right = i;
                break;
            }
        }
        for (int i = right + 1; i < nums.length; ++i) {
            if (nums[i] != target) break;
            right++;
        }
        return new int[]{left, right};
    }

    public static int[] searchRange2(int[] nums, int target) {
        //第一个等于TARGET的位置，即左边界
        int left = binarySearch(nums,target,true);
        //第一个大于TARGET的位置，需要减一，得到右边界
        int right = binarySearch(nums,target,false) - 1;
        if (left <= right && right < nums.length && nums[left] ==target &&nums[right] ==target){
            return new int[]{left,right};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) /2;
            //lower && nums[mid]>=target其实是校验等于target的时候，是否左移右边界去找最小的等于target的位置
            if (nums[mid]>target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 7, 7, 8, 8, 10};
        searchRange2(test, 8);
    }
}
