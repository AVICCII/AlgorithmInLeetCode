package labuladongAlgorithm.双指针;

import labuladongAlgorithm.basic.ListNode;

/**
 * @author aviccii 2021/1/12
 * @Discrimination 判断链表中是否有环
 */
public class hasCycleTest {

    /**
     * 判断链表中是否有环，经典解法是双指针，其中一个快一个慢。如果不含有环，跑得快的那个指针最终会遇到null，说明链表不含有环；
     * 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环。
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head){
        ListNode fast,slow;
        //初始化快、慢指针指向头节点
        fast = slow = head;
        while (fast != null && fast.next !=null) {
            //快指针每次前进两步
            fast = fast.next.next;
            //慢指针每次前进一步
            slow = slow.next;
            //如果存在环，快、慢指针必然相遇
            if (fast == slow) return true;
        }
        return false;
    }

}
