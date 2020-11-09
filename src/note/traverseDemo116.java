package note;

/**
 * @author aviccii 2020/11/6
 * @Discrimination
 */
public class traverseDemo116 {
    public Node connect(Node root) {
        nextConnect(root.left,root.right);
        return root;
    }

    public static void nextConnect(Node one,Node two){
        //base
        if (one == null||two==null){
            return;
        }

        one.next = two;

        nextConnect(one.left,one.right);
        nextConnect(two.left,two.right);
        nextConnect(one.right,two.left);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};