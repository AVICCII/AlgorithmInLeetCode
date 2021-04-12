package labuladongAlgorithm.n数之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aviccii 2021/3/23
 * @Discrimination
 */
public class 两数之和 {
    int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            //根据sum和target比较，移动左右指针
            if (sum < target) low++;
            else if (sum > target) high--;
            else return Arrays.copyOfRange(nums, low, high);
        }
        return null;
    }

    /**
     * nums 中可能有多对儿元素之和都等于 target，请你的算法返回所有和为 target 的元素对儿，其中不能出现重复。
     * @param nums
     * @param target
     * @return
     */
     public static List<int[]> twoSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        List<int[]> list = new LinkedList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target) while (low < high && nums[low] == left) low++; //跳过相同的元素
            else if (sum > target) while (low < high && nums[high] == right) high--;
            else {
                list.add(Arrays.copyOfRange(nums, low, high));
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return list;
    }



}
