package labuladongAlgorithm.二叉树;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/26
 * @Discrimination
 */
public class 构造最大二叉树 {

    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {

        if (lo > hi) return null;

        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);

        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }


}
