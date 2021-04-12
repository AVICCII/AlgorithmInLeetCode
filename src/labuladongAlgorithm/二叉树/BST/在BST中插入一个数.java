package labuladongAlgorithm.二叉树.BST;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/25
 * @Discrimination
 */
public class 在BST中插入一个数 {
    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) insertIntoBST(root.right, val);
        if (root.val > val) insertIntoBST(root.left, val);
        return root;
    }
}
