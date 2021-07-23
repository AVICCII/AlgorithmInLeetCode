package leetcodeStar.算法入门.day10;

import labuladongAlgorithm.basic.ListNode;

/**
 * @author aviccii 2021/7/15
 * @Discrimination
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), cur = ans;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            } else {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
        }
        cur.next = (l1 == null) ? l2 : l1;
        return ans.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        //l1,l2均不为0
        //l1比l2小，当前节点为l1,当前节点的next指向l1.next与l2的递归
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            //返回当前节点，后续节点通过上述递归已然有序
            return l1;
        }
        //l1,l2均不为0
        //l2比l1小，当前节点应为l2,当前节点的next指向l2.next与l1的递归
        else {
            l2.next = mergeTwoLists2(l1, l2.next);
            //返回当前节点，后续节点通过上述递归已然有序
            return l2;
        }

    }

}
