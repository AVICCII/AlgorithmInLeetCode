package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/8/4
 * @Discrimination 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
{1,2,3,4,5},1 {5}

 */
public class JZ14_链表中倒数最后k个节点 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here

        ListNode check = pHead;

        for (int i = 0; i < k; i++) {
            check = check.next;
        }

        while (check!=null){
            pHead = pHead.next;
            check = check.next;
        }

        return pHead;

    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
