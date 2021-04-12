package 剑指offer;

import labuladongAlgorithm.basic.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author aviccii 2021/3/17
 * @Discrimination
 */
public class case06从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int[] ans = new int[count];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i]=node.val;
            node=node.next;
        }
        return ans;
    }
}
