package leetcodeStar.算法入门.day2;

/**
 * @author aviccii 2021/7/7
 * @Discrimination
 */
public class 有序数组的平方 {
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) nums[i] = (int) Math.pow(nums[i], 2);
        QuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            QuickSort(arr, low, partition - 1);
            QuickSort(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) negative = i;
            else break;
        }

        //双指针解法
        int[] ans = new int[n];
        //negative是最后一个负数的位置
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                //如果负数处理完了,同时j没有达到数组尾部，剩余的都加j
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                //如果正数部分都处理完了，那么后续都加负数部分的平方值
                ans[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                //比较大小，小的先进
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    //使用两个指针分别指向位置 0 和 n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
    // 这种方法无需处理某一指针移动至边界的情况
    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


}
