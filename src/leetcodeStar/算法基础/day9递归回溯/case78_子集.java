package leetcodeStar.算法基础.day9递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/8/18
 * @Discrimination
 */
public class case78_子集 {
    static   List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        //取值的情况
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        //返回现场
        t.remove(t.size() - 1);
        //不取值的情况
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

}
