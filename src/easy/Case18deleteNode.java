package easy;

/**
 *
 * @author aviccii 2020/8/17
 * 删除链表指定节点
 */
public class Case18deleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}