package note;

/**
 * @author aviccii 2020/11/4
 * @Discrimination
 */
public class traverseDemo114 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode aLeft = new TreeNode(4);
        TreeNode aRight = new TreeNode(5);
        TreeNode bRight = new TreeNode(6);
        a.left=aLeft;
        a.right = aRight;
        System.out.println(a);
        TreeNode b=a;
        System.out.println(b);
        System.out.println(a.right.right);
        b=b.right;
        b.right=bRight;
        System.out.println(b.right);
        System.out.println(a.right.right);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.right);
    }


    public void flatten(TreeNode root){
        // base
        if (root==null){
            return;
        }

        //前提：左右子树已被拉平。这里进行处理
        flatten(root.left);
        flatten(root.right);

        //后序遍历
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树作为右子树
        root.left=null;
        root.right=left;

        //将原先的右子树接到当前右子树的末端
        while (root.right != null){
            root = root.right;
        }
        root.right = right;
    }
}

 class TreeNode {
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