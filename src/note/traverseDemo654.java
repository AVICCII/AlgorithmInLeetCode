package note;

/**
 * @author aviccii 2020/11/9
 * @Discrimination
 */
public class traverseDemo654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursionSearch(nums,0,nums.length-1);
    }

    public TreeNode recursionSearch(int[] nums,int lo,int hi){

        //base
        if (lo>hi) return null;

        int maxIndex = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>maxVal){
                maxIndex= i;
                maxVal= nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = recursionSearch(nums,lo,maxIndex-1);
        root.right = recursionSearch(nums,maxIndex+1,hi);

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
