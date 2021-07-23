package leetcodeStar.算法基础.day1二分查找;

/**
 * @author aviccii 2021/7/20
 * @Discrimination
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //找到位置则返回
            if (nums[mid] == target) return mid;
            //如果中点值大于该数列的第一个值，则可以证明前mid个数组是有序的
            if (nums[0] <= nums[mid]){
                //如果目标值在nums[0,mid]范围，那么进一步缩小右边界
                if (nums[0] <= target && nums[mid] > target) {
                    r = mid - 1;
                }
                //其他的则提升左边界到右边去找
                else l = mid + 1;
            }//如果中点值小于初始值，那么说明前面Mid个数只是部分有序，后面mid个数一定是有序的，从右边开始找
            else {
                //如果target在[mid,nums.length -1]位置，则缩小左边界
                if (nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }
                //其他的缩小右边界去左边找
                else  r = mid - 1;
            }
        }
        return - 1;
    }
}
