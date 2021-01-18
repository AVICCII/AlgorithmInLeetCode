package labuladongAlgorithm.双指针;

import labuladongAlgorithm.basic.ListNode;

import java.util.List;

/**
 * @author aviccii 2021/1/14
 * @Discrimination
 */
public class detectCycle {
    ListNode detectCycle(ListNode head){
        ListNode fast,slow;
        fast = slow = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        //上面的代码类似hasCycle函数
        //先把一个指针重新指向head
        slow = head;
        while (slow != fast){
            //两个指针以相同的速度前进
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
