package leetcodeStar.day8;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/7/13
 * @Discrimination
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode res = new TreeNode(root1.val+root2.val);
        res.left = mergeTrees(root1.left, root2.left);
        res.right = mergeTrees(root1.right, root2.right);
        return res;
    }
}
