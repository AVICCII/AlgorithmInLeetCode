package 牛客.剑指OFFER;

import labuladongAlgorithm.basic.ListNode;

/**
 * @author aviccii 2021/8/4
 * @Discrimination 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 输入：
 * {1,3,5},{2,4,6}
 * 返回值：
 * {1,2,3,4,5,6}
 */
public class JZ16_合并两个有序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (list1 != null && list2 != null){
            if (list1.val>list2.val) {
                cur.next = new ListNode(list2.val);
                cur = cur.next;
                list2 = list2.next;
            }
            else {
                cur.next = new ListNode(list1.val);
                cur = cur.next;
                list1 = list1.next;
            }
        }

        if (list1!=null) cur.next = list1;
        if (list2!=null) cur.next = list2;

        return res.next;
    }
}
