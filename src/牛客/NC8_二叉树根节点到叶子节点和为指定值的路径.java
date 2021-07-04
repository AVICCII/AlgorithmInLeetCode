package 牛客;

import labuladongAlgorithm.basic.TreeNode;

import java.util.ArrayList;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 0:08 2021/7/4
 */
public class NC8_二叉树根节点到叶子节点和为指定值的路径 {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        process(root, sum, 0);
        return ans;
    }

    public void process(TreeNode root, int sum, int tempVal) {
        if (root == null) return;
        res.add(root.val);
        tempVal += root.val;

        if (root.left == null && root.right == null) {

            if (tempVal == sum) {
                ans.add(new ArrayList<>(res));
            }
        } else {
            process(root.left, sum, tempVal);
            process(root.right, sum, tempVal);
        }

        //恢复现场
        res.remove(res.size() - 1);
    }
}
