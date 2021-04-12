package labuladongAlgorithm.二叉树.BST;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/29
 * @Discrimination
 */
public class BST转换累加树 {

    TreeNode convertBT(TreeNode root){
        traverse(root);
        return root;
    }

    //记录累加和
    int sum = 0;
    void traverse(TreeNode root){
        if (root == null) return;

        traverse(root.right);
        sum+=root.val;
        //转换成累加树
        root.val = sum;
        traverse(root.left);
    }
}
