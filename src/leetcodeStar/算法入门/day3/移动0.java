package leetcodeStar.算法入门.day3;

/**
 * @author aviccii 2021/7/8
 * @Discrimination
 */
public class 移动0 {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            }
        }
    }


    public void moveZeroes2(int[] nums) {
        QuickSort(nums, 0, nums.length - 1);
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) pos = i;
        }
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,pos);

    }

    public static void reverse(int[] num, int start, int end) {
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    public static void QuickSort(int[] num, int left, int right) {
        if (left < right) {
            int partition = partition(num, left, right);
            QuickSort(num, left, partition - 1);
            QuickSort(num, partition + 1, right);
        }
    }

    private static int partition(int[] num, int left, int right) {
        int pivot = num[left];
        while (left < right) {
            while (left < right && num[right] >= pivot) right--;
            num[left] = num[right];
            while (left < right && num[left] <= pivot) left++;
            num[right] = num[left];
        }
        num[left] = pivot;
        return pivot;
    }

    public static void main(String[] args) {

    }
}
