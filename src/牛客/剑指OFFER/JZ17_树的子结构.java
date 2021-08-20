package 牛客.剑指OFFER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/8/5
 * @Discrimination
 */
public class JZ17_树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preRecursive(root1, list1);
        preRecursive(root2, list2);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                while (list1.get(i).equals(list2.get(j))){
                    if (j==list2.size() - 1) return true;
                    if (i==list1.size() - 1) break;
                    i++;
                    j++;
                }
            }
        }
        return false;
    }

    public void preRecursive(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preRecursive(root.left, list);
        preRecursive(root.right, list);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
