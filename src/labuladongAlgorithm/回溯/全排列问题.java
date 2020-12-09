package labuladongAlgorithm.回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aviccii 2020/12/9
 * @Discrimination 回溯问题本身就是暴力穷举
 */
public class 全排列问题 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> permute = permute(a);
        System.out.println(Arrays.toString(permute.toArray()));
    }

    /*
    主函数，输入一组不重复的数字，返回他们的全排列
     */
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    //路径：记录在track当中
    //选择列表：nums中不存在于track的那些元素
    //结束条件：nums中的元素全都在track中出现
    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])) continue;
            //选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }
}
