package labuladongAlgorithm.二叉树;

import labuladongAlgorithm.basic.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aviccii 2021/3/29
 * @Discrimination
 */
public class 寻找重复子树 {

    //记录所有的子树及出现的次数
    HashMap<String,Integer> memo = new HashMap<>();

    //记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

    /* 辅助函数 */
    String traverse(TreeNode root){
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right+ "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

}
