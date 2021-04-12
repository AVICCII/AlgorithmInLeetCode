package labuladongAlgorithm.二叉树.BST;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/29
 * @Discrimination
 */
public class 寻找BST中第K小的元素 {
    int kthSmallest(TreeNode root, int k) {
        //利用BST的中序遍历特性
        traverse(root, k);
        return res;
    }

    //记录结果
    int res = 0;
    //记录当前元素的排名
    int rank = 0;

    void traverse(TreeNode root, int k) {
        if (root ==null) return;

        traverse(root.left,k);
        rank++;
        if (k==rank){
            res = root.val;
            return;
        }

        traverse(root.right,k);

    }
}
