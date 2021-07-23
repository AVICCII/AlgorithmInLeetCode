package 牛客.剑指OFFER;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/22
 * @Discrimination
 */
public class JZ4_重建二叉树 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);

        //找到前序的根在中序的位置
        int rootPos = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootPos = i;
                break;
            }
        }
        //构建下一次递归的数组
        int[] nextPreLeft = Arrays.copyOfRange(pre, 1, rootPos + 1);
        int[] nextInLeft = Arrays.copyOfRange(in, 0, rootPos);
        int[] nextPreRight = Arrays.copyOfRange(pre, rootPos + 1, pre.length);
        int[] nextInRight = Arrays.copyOfRange(in, rootPos + 1, pre.length);

        root.left = reConstructBinaryTree(nextPreLeft, nextInLeft);
        root.right = reConstructBinaryTree(nextPreRight, nextInRight);

        return root;
    }

    public static void main(String[] args) {
        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
