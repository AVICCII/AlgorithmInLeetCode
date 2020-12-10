package labuladongAlgorithm.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author aviccii 2020/12/10
 * @Discrimination
 */
public class openLock {

    /**
     * @param deadEnds 不可以拨的密码，即target不可由该密码移动一位得到
     * @param target  目标密码
     * @return  拨出目标密码的次数，无法拨出则返回-1
     */
    public int openLock(String[] deadEnds, String target) {
        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String deadEnd : deadEnds) deads.add(deadEnd);
        //记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        //从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            //将当前队列扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                //判断密码是否合法，是否到达终点
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                //将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    //向下拨一位
    private String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return cur = new String(ch);
    }

    //向上拨一位
    private String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;
        return cur = new String(ch);
    }
}
