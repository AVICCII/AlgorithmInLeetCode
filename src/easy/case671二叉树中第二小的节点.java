package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author aviccii 2021/7/27
 * @Discrimination
 */
public class case671二叉树中第二小的节点 {
    int res ;
    int rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        rootVal = root.val;
        search(root);
        return res;
    }

    public void search(TreeNode root){
        if (root == null) return;
        if (res != -1 && root.val >= res) return;

        if (root.val > rootVal) res = root.val;

        search(root.left);
        search(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
