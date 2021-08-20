package leetcodeStar.算法基础.day10递归回溯;

import java.util.*;

/**
 * @author aviccii 2021/8/20
 * @Discrimination
 */
public class 组合总和Ⅱ {
     List<Integer> temp = new ArrayList<>();
     List<List<Integer>> res = new ArrayList<>();
     Set<List<Integer>> memo = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursive(candidates,target,0,0);
        return res;
    }

    public void recursive(int[] candidates,int target,int cur,int curSum){
        if (cur == candidates.length) return;
        if (curSum == target) {
            if(!memo.contains(temp)){
                memo.add(new ArrayList<>(temp));
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        else if (curSum>target) return;

        temp.add(candidates[cur]);
        curSum += candidates[cur];
        recursive(candidates,target,cur+1,curSum);
        temp.remove(temp.size() - 1);
        curSum -= candidates[cur];
        recursive(candidates,target,cur+1,curSum);
    }
}
