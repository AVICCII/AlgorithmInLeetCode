package 牛客;

import labuladongAlgorithm.basic.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/7/7
 * @Discrimination
 */
public class NC70_单链表的排序 {

    public ListNode sortInList (ListNode head) {
        if (head == null || head.next == null) return head;
        //使用快慢指针找到中点
        ListNode slow = head,fast =head.next;
        while (fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newList = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left!=null?left:right;
        return res.next;
    }
}
