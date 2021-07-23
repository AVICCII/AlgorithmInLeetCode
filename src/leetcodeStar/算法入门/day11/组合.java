package leetcodeStar.算法入门.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/7/16
 * @Discrimination
 */
public class 组合 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        process(n,k,1);
        return res;
    }

    public void process(int n, int k, int cur) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (tmp.size() + (n - cur + 1) < k) return;
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(cur);
        process(n,k,cur+1);

        tmp.remove(tmp.size() - 1);
        process(n,k,cur+1);
    }
}
