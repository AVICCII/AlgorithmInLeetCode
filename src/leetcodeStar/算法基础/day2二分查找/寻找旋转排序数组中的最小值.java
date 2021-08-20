package leetcodeStar.算法基础.day2二分查找;

/**
 * @author aviccii 2021/7/22
 * @Discrimination
 */
public class 寻找旋转排序数组中的最小值 {
    //我们考虑数组中的最后一个元素 x：在最小值右侧的元素（不包括最后一个元素本身），它们的值一定都严格小于 x；而在最小值左侧的元素，
    // 它们的值一定都严格大于 x。因此，我们可以根据这一条性质，通过二分查找的方法找出最小值。
    //
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            //在最小值右侧的元素（不包括最后一个元素本身），它们的值一定都严格小于 x,如果pivot小于最右侧数，说明在最小值右侧
            //收窄右边界
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }


    public int findMin2(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int pivot = low + (high - low) >> 1;
            if (nums[pivot] < nums[high]) high = pivot;
            else low = pivot + 1;
        }
        return nums[low];
    }
}
