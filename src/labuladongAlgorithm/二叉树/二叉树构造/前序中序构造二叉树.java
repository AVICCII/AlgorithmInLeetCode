package labuladongAlgorithm.二叉树.二叉树构造;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/26
 * @Discrimination
 */
public class 前序中序构造二叉树 {

    TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
