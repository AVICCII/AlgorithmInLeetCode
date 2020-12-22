package labuladongAlgorithm.BFS;

import labuladongAlgorithm.basic.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author aviccii 2020/12/10
 * @Discrimination
 */
public class minDepth {


    //BFS算法java实现，利用了queue队列的数据结构。首先，根节点进入queue，之后不断判断queue的size,为0则结束。在循环体内，首先将
    //root节点poll出来，然后进行操作（取值等），操作完成后，将root的左右节点（如果有）offer进queue里，继续判定。当为空时，不入
    //队列，则到最后，叶子节点遍历完成poll出来后，队列也为空，最后返回需要的结果。
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //root本身就是1层
        int depth = 1;


        while (!q.isEmpty()) {
            int sz = q.size();
            //将当前队列中的所有节点扩散
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                //判断是否到达终点
                if (curr.left == null && curr.right == null) return depth;
                //将curr的左右邻接点加入队列
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
}
