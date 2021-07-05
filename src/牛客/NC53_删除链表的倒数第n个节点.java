package 牛客;

import labuladongAlgorithm.basic.ListNode;

import java.util.List;

/**
 * @author aviccii 2021/7/5
 * @Discrimination
 */
public class NC53_删除链表的倒数第n个节点 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode ans = new ListNode(0);
        ListNode cur = ans,check = head;
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }
        if (len == n) return check.next;

        for (int i = 0; i < len; i++) {
            if (n == 1 && i == len - n) break;
            if (i == len - n ){
                cur.next = new ListNode(check.next.val);
                cur = cur.next;
                check = check.next.next;
                continue;
            }
            if (check == null) break;
            cur.next = new  ListNode(check.val);
            cur = cur.next;
            check = check.next;
        }

        return ans  ;
    }


    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        removeNthFromEnd(s1,2);
    }
}
