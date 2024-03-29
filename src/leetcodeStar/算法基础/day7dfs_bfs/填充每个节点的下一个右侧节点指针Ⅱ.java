package leetcodeStar.算法基础.day7dfs_bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author aviccii 2021/8/10
 * @Discrimination
 */
public class 填充每个节点的下一个右侧节点指针Ⅱ {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                Node last = null;
                for (int i = 1; i <= n; ++i) {
                    Node f = queue.poll();
                    if (f.left != null) {
                        queue.offer(f.left);
                    }
                    if (f.right != null) {
                        queue.offer(f.right);
                    }
                    if (i != 1) {
                        last.next = f;
                    }
                    last = f;
                }
            }
            return root;
        }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

