package leetcodeStar.算法基础.day3双指针;

import labuladongAlgorithm.basic.ListNode;

/**
 * @author aviccii 2021/7/23
 * @Discrimination
 */
public class 删除排序链表中的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int repeatVal = cur.next.val;
                while (cur.next!=null && cur.next.val==repeatVal){
                    cur.next = cur.next.next;
                }
            }else  cur = cur.next;
        }
        return res.next;
    }
}
