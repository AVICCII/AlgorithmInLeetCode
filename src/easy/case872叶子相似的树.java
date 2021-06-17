package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/5/10
 * @Discrimination
 */
public class case872叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        if (root1 != null) dfs(root1, list1);
        if (root2 != null) dfs(root2, list2);

        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) list.add(root.val);
        else {
            if (root.left != null) dfs(root.left, list);
            if (root.right != null) dfs(root.right, list);
        }
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

