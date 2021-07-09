package 牛客;

import labuladongAlgorithm.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aviccii 2021/7/6
 * @Discrimination
 */
public class NC14_二叉树的之字形层序遍历 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i--) {
                TreeNode node = queue.poll();//弹出节点

                if((res.size()+1)%2 != 0) temp.add(node.val);
                else temp.add(0,node.val);

                if (node.left != null) queue.add(node.left);

                if (node.right!=null) queue.add(node.right);
            }
            res.add(temp);
        }
      return res;
    }
}
