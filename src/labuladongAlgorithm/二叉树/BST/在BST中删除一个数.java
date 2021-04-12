package labuladongAlgorithm.二叉树.BST;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/3/25
 * @Discrimination
 */
public class 在BST中删除一个数 {
    TreeNode deleteNode(TreeNode root,int key){
        //base
        if (root ==null) return null;
        if (root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //处理有两个子节点的待删除节点
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right,minNode.val);
        }else if (root.val >key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }


}
