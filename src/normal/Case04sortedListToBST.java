package normal;

/**
 * @author aviccii 2020/8/18
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 */
public class Case04sortedListToBST {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        public TreeNode buildTree(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
            ListNode mid = getMedian(left, right);
            TreeNode root = new TreeNode(mid.val);
            root.left = buildTree(left, mid);
            root.right = buildTree(mid.next, right);
            return root;
        }

        public ListNode getMedian(ListNode left, ListNode right) {
            ListNode fast = left;
            ListNode slow = left;
            while (fast != right && fast.next != right) {
                fast = fast.next;
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

    }
    /**
     * 我们可以直接模拟「前言」部分的构造方案。
     *
     * 具体地，设当前链表的左端点为 \textit{left}left，右端点 \textit{right}right，包含关系为「左闭右开」，即 \textit{left}left 包含在链表中而 \textit{right}right 不包含在链表中。我们希望快速地找出链表的中位数节点 \textit{mid}mid。
     *
     * 为什么要设定「左闭右开」的关系？由于题目中给定的链表为单向链表，访问后继元素十分容易，但无法直接访问前驱元素。因此在找出链表的中位数节点 \textit{mid}mid 之后，如果设定「左闭右开」的关系，我们就可以直接用 (\textit{left}, \textit{mid})(left,mid) 以及 (\textit{mid}.\textit{next}, \textit{right})(mid.next,right) 来表示左右子树对应的列表了。并且，初始的列表也可以用 (\textit{head}, \textit{null})(head,null) 方便地进行表示，其中 \textit{null}null 表示空节点。
     *
     * 找出链表中位数节点的方法多种多样，其中较为简单的一种是「快慢指针法」。初始时，快指针 \textit{fast}fast 和慢指针 \textit{slow}slow 均指向链表的左端点 \textit{left}left。我们将快指针 \textit{fast}fast 向右移动两次的同时，将慢指针 \textit{slow}slow 向右移动一次，直到快指针到达边界（即快指针到达右端点或快指针的下一个节点是右端点）。此时，慢指针对应的元素就是中位数。
     *
     * 在找出了中位数节点之后，我们将其作为当前根节点的元素，并递归地构造其左侧部分的链表对应的左子树，以及右侧部分的链表对应的右子树。
     *
     */
}


