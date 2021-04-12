package labuladongAlgorithm.n数之和;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aviccii 2021/3/23
 * @Discrimination
 */
public class 四数之和 {


    //四数之和调用三数之和，修改参数
    List<List<Integer>> fourSum(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> triples = ThreeSumTarget(nums, i, target - nums[i]);
            for (List<Integer> triple : triples) {
                triple.add(nums[i]);
                res.add(triple);
            }
        }
        return res;
    }


    //重构两数之和，添加target参数
    public static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        Arrays.sort(nums);
        int low = start, high = nums.length - 1;
        List<List<Integer>> list = new LinkedList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target) while (low < high && nums[low] == left) low++; //跳过相同的元素
            else if (sum > target) while (low < high && nums[high] == right) high--;
            else {
                int[] ints = Arrays.copyOfRange(nums, low, high);
                list.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return list;
    }

    //计算数组nums中所有和为target的三元组
    public static List<List<Integer>> ThreeSumTarget(int[] nums,int start, int target) {
        //数组排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        //穷举threeSum的第一个数
        for (int i = start; i < n; i++) {
            //对 target - nums[i] 计算twoSum
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            //如果存在满足条件的二元组，再加上nums[i]就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //跳过第一个数组重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }


}
