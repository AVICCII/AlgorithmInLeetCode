package labuladongAlgorithm.二叉树;

/**
 * @author aviccii 2021/3/24
 * @Discrimination
 */
public class 填充每个节点的下一个右侧节点指针 {

    TreeNode connect(TreeNode root){
        if (root==null||root.right==null) return root;
        connectTwoNode(root.left,root.right);
        return root;
    }

    void connectTwoNode(TreeNode node1,TreeNode node2){
        if (node1 == null|| node2 == null) return;

        node1.next = node2;

        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node1.right,node2.left);
        connectTwoNode(node2.left,node2.right);
    }

    private class TreeNode{
        int val;
        TreeNode next;
        TreeNode left;
        TreeNode right;
    }
}
