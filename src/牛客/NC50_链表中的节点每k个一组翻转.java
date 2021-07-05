package 牛客;

import java.util.List;
import java.util.Stack;

/**
 * @author aviccii 2021/7/5
 * @Discrimination将给出的链表中的节点每k个一组翻转，返回翻转后的链表 如果链表中的节点数不是k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度  O(1)
 * 例如：
 * 给定的链表是1→2→3→4→5
 * 对于 k=2, 你应该返回 2→1→4→3→5
 * 对于k=3, 你应该返回 3→2→1→4→5
 */
public class NC50_链表中的节点每k个一组翻转 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        int len = 0;
        ListNode temp,cur = head,pre = res;
        while (head.next!=null) {
            len++;
            head = head.next;
        }

        for (int i = 0; i < len / k; i++) {
            for (int j = i; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
            this.val = i;
        }
    }
}
