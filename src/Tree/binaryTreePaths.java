package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aviccii 2020/9/4
 * @Discrimination 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class binaryTreePaths {

 public List<String> binaryTreePaths(TreeNode root) {
  List<String> ans = new ArrayList<>();
  constructPaths(root,"",ans);
 return ans;
 }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
 public void constructPaths(TreeNode root,String path,List<String> paths){
  if (root!=null){
   StringBuffer stringBuffer = new StringBuffer(path);
   stringBuffer.append(Integer.toString(root.val));
   if (root.right==null&root.left==null){
    paths.add(stringBuffer.toString());
   }else {
    stringBuffer.append("->");
    constructPaths(root.left,stringBuffer.toString(),paths);
    constructPaths(root.right,stringBuffer.toString(),paths);
   }
  }
 }
}

