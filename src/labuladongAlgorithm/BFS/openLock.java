package labuladongAlgorithm.BFS;

import java.util.*;

/**
 * @author aviccii 2020/12/10
 * @Discrimination
 */
public class openLock {


    public static void main(String[] args) {
        String[] deadEnds = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        openLock(deadEnds,target);
    }

    /**
     * @param deadEnds 不可以拨的密码，即target不可由该密码移动一位得到
     * @param target  目标密码
     * @return  拨出目标密码的次数，无法拨出则返回-1
     */
    public static int openLock(String[] deadEnds, String target) {
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
    public static String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return cur = new String(ch);
    }

    //向上拨一位
    public static String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;
        return cur = new String(ch);
    }


    public int openLockDouble(String[] deadends, String target){
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        //用集合不用队列，可以快速判断元素是否存在
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        set1.add("0000");
        set2.add(target);

        while (!set1.isEmpty()&&!set2.isEmpty()){
            //哈希集合在遍历的过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<>();

            /*
            将set1中所有的节点向周围扩散
             */
            for (String cur : set1) {
                //判断是否到达终点
                if (deads.contains(cur)) continue;
                if (set2.contains(cur)) return step;
                visited.add(cur);

                //将一个节点的未遍历相邻节点加入集合
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur,j);
                    if (!visited.contains(up)) temp.add(up);
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)) temp.add(down);
                }
            }
            //在这里增加步数
            step++;
            //temp相当于set1
            //这里交换set1 set2,下一轮while就是扩散set2
            set1 = set2;
            set2 = temp;
        }
        return -1;
    }
}
