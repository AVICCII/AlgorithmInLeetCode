package labuladongAlgorithm.BFS;

import labuladongAlgorithm.basic.ListNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author aviccii 2020/12/10
 * @Discrimination
 */
public class BFS {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(20);
    }

    public int Bfs(ListNode start,ListNode target){
        Queue<ListNode> queue = new LinkedList<>();
        Set<ListNode> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;

        while (queue.size()!=0){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                ListNode cur = queue.poll();
                if (cur == target) return step;
                else {
                    if (cur.next!=null){
                        ListNode x = cur.next;
                        if (!visited.contains(x)){
                            queue.offer(x);
                            visited.add(x);
                        }
                    }
                }
            }
            step++;
        }
        return 1;
    }
}
