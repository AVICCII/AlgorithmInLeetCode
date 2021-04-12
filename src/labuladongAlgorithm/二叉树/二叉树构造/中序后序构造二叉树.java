package labuladongAlgorithm.二叉树.二叉树构造;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/26
 * @Discrimination
 */
public class 中序后序构造二叉树 {

    TreeNode build(int[] inOrder, int inStart, int inEnd,
                   int[] postOrder, int postStart, int postEnd) {

        if (inStart > inEnd) return null;

        int rootVal = postOrder[postEnd];
        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(inOrder, inStart, index - 1,
                postOrder, postStart, postStart + leftSize - 1);

        root.right = build(inOrder, index + 1, inEnd,
                postOrder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
