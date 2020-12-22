package labuladongAlgorithm.BFS;


import java.util.*;

/**
 * @author aviccii 2020/12/22
 * @Discrimination 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class case103zigzagLevelOrder {

    public static void main(String[] args) {
        //队列测试 poll出队列，offer入队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        queue.offer(3);
        System.out.println(queue.poll());
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(list);
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> list = ans.get(i);
                Collections.reverse(list);
            }
        }
        return ans;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
