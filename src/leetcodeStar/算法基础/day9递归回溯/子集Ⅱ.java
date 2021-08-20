package leetcodeStar.算法基础.day9递归回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author aviccii 2021/8/18
 * @Discrimination
 */
public class 子集Ⅱ {
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    public void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            if (!set.contains(res)) ans.add(new ArrayList<>(res));
            set.add(res);
            return;
        }

        res.add(nums[cur]);
        dfs(nums, cur + 1);
        res.remove(res.size() - 1);
        dfs(nums, cur + 1);
    }
}
