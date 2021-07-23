package leetcodeStar.算法入门.day10;

import labuladongAlgorithm.basic.ListNode;

import java.util.Stack;

/**
 * @author aviccii 2021/7/15
 * @Discrimination
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        ListNode ans = new ListNode(0),res = ans;

        while (!stack.isEmpty()){
            ans.next = new ListNode(stack.pop());
            ans = ans.next;
        }
        return res.next;
    }

    public ListNode reverseList2(ListNode head) {
        char a = 'a';

        ListNode prev = null,cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
