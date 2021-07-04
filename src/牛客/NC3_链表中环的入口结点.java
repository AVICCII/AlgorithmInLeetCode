package 牛客;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 17:08 2021/7/4
 */
public class NC3_链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) return null;

        ListNode fast =pHead;
        ListNode slow = pHead;

        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = pHead;
                while (slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }

    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }
}
