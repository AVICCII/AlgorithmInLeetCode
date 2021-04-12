package labuladongAlgorithm.二叉树;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/24
 * @Discrimination 将以root为根的树拉平为链表
 */
public class 二叉树展开为链表 {
    void flatten(TreeNode root){
        //base
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        //后序遍历
        //1.左右子树已经拉平为一个链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2.将左子树作为右子树
        root.left = null;
        root.right = left;

        //3.将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right!=null) p = p.right;
        p.right = right;

    }
}
