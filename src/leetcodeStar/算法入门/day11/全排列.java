package leetcodeStar.算法入门.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aviccii 2021/7/16
 * @Discrimination
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        process(tmp, 0, res);
        return res;
    }

    public void process(List<Integer> nums, int i,  List<List<Integer>> res) {
        if (i == nums.size()) res.add(new ArrayList<>(nums));
        for (int j = i; j < nums.size(); j++) {
            Collections.swap(nums,i,j);
            process(nums, i + 1, res);
            Collections.swap(nums, i, j);
        }
    }

}
