package note;

/**
 * @author aviccii 2020/11/9
 * @Discrimination
 */
public class traverseDemo105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //base
        if (preorder.length==0||inorder.length==0) return null;

        TreeNode ans = build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return ans;
    }

    public TreeNode build(int[] preorder, int preLo, int preHi,
                          int[] inorder, int inLo, int inHi) {

        //base
        if (preHi<preLo && inHi<inLo) return null;

        int startRoot = preorder[preLo];
        int inIndex = 0;
        for (int i = 0; i <=inorder.length; i++) {
            if (inorder[i] == startRoot) {
                inIndex = i;
            }
        }
        int leftLength = inIndex - preLo;
        TreeNode root = new TreeNode(startRoot);
        root.left = build(preorder, preLo + 1, preLo + leftLength,
                inorder, inLo, inIndex-1);
        root.right = build(preorder,preLo+leftLength+1,preHi,
                inorder,inIndex+1,inHi );
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
