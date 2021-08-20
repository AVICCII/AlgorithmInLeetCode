package 牛客.剑指OFFER;

import labuladongAlgorithm.basic.TreeNode;

/**
 * @author aviccii 2021/8/6
 * @Discrimination
 */
public class JZ18_二叉树的镜像 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pRoot TreeNode类
         * @return TreeNode类
         */
        public TreeNode Mirror(TreeNode pRoot) {
            // write code here
            if (pRoot==null) return null;
            TreeNode tmp = pRoot.right;
            pRoot.right = pRoot.left;
            pRoot.left = tmp;
            Mirror(pRoot.left);
            Mirror(pRoot.right);
            return pRoot;

        }
    }
}
