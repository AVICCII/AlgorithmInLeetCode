package note;

/**
 * @author aviccii 2020/11/10
 * @Discrimination
 */
public class traverseDemo106 {
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        return bulid(inorder, 0, inorder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    public TreeNode bulid(int[] inorder, int inLo, int inHi,
                          int[] postOrder, int poLo, int poHi) {
        //base
        if (inLo>inHi) return null;

        int startVal = postOrder[poHi];
        int inIndex = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == startVal){
                inIndex=i;
                break;
            }
        }

        int leftLength = inIndex - inLo;

        TreeNode root = new TreeNode(startVal);
        root.left= bulid(inorder,inLo,inIndex-1,
                postOrder,poLo,poLo+leftLength-1);
        root.right = bulid(inorder,inIndex+1,inHi,
                postOrder,poLo+leftLength,poHi-1);
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
