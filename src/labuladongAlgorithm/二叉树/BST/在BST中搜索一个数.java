package labuladongAlgorithm.二叉树.BST;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/25
 * @Discrimination
 */
public class 在BST中搜索一个数 {
    //穷举方法，未用到BST的特性
    boolean isInBsT(TreeNode root,int target){
        //base
        if (root==null) return false;
        if (root.val == target) return true;
        return isInBsT(root.left,target) || isInBsT(root.right,target);
    }

    boolean isInBsT2(TreeNode root, int target){
        //base
        if (root==null) return false;
        if (root.val == target) return true;
        if (root.val > target) return isInBsT(root.left,target);
        else return isInBsT(root.right,target);
    }
}
