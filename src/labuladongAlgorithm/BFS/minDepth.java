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
    public int minDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //root本身就是1层
        int depth = 1;

        while (!q.isEmpty()){
            int sz = q.size();
            //将当前队列中的所有节点扩散
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                //判断是否到达终点
                if (curr.left==null&&curr.right==null) return depth;
                //将curr的左右邻接点加入队列
                if (curr.left !=null) q.offer(curr.left);
                if (curr.right !=null) q.offer(curr.right);
            }
            depth++;
        }
                return depth;
                }
                }
