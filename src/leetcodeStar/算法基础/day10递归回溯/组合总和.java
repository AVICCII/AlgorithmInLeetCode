package leetcodeStar.算法基础.day10递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/8/20
 * @Discrimination 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 */
public class 组合总和 {

    static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates,int target){
        recursive(candidates,0,0,target);
        return res;
    }

    public static void recursive(int[] candidates,int cur,int curSum,int target){
        if (cur == candidates.length) return;
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        else if (curSum > target){
            return;
        }

        temp.add(candidates[cur]);
        curSum += candidates[cur];
        recursive(candidates, cur, curSum, target);
        temp.remove(temp.size() - 1);
        curSum -= candidates[cur];
        recursive(candidates, cur + 1, curSum, target);
    }


    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
}
