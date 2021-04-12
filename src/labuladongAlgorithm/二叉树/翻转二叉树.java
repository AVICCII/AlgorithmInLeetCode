package labuladongAlgorithm.二叉树;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/24
 * @Discrimination 输入一个二叉树根节点root，让你把整棵树镜像翻转(反转左右子节点)
 */
public class 翻转二叉树 {
    TreeNode invertTree(TreeNode root) {
        //base
        if (root == null) return null;
        TreeNode temp =root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
