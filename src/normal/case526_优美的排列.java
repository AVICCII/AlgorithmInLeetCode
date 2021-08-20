package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/8/16
 * @Discrimination假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，
 * 使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * <p>
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 */
public class case526_优美的排列 {
    List<Integer>[] match;
    boolean[] vis;
    int num;

    public int countArrangement(int n) {
        vis = new boolean[n + 1];
        //在i位置符合要求的数字j的集合
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //在i位置符合要求的数字j
                if (i % j == 0 || j % i == 0) match[i].add(j);
            }
        }
        backtrack(1, n);
        return num;
    }

    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }

        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                //还原现场
                vis[x] = false;
            }
        }
    }
}
