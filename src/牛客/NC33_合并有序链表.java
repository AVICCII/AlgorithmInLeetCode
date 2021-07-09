package 牛客;

import labuladongAlgorithm.basic.ListNode;

/**
 * @author aviccii 2021/7/7
 * @Discrimination
 */
public class NC33_合并有序链表 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1!=null && l2!=null){
            if (l1.val >l2.val) {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }else {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
        }
        cur.next = (l1 == null)? l2:l1;
        return ans.next;
    }
}
