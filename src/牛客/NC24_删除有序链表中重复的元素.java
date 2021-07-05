package 牛客;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aviccii 2021/7/5
 * @Discrimination
 */
public class NC24_删除有序链表中重复的元素 {
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        Set<Integer> singleSet = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();

        ListNode check = head,ans = new ListNode(0),cur = ans;

        while (check!=null){
            if (singleSet.contains(check.val)) {
                repeatSet.add(check.val);
            }else singleSet.add(check.val);
            check = check.next;
        }

        while (head != null){
            if (!repeatSet.contains(head.val)) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return ans.next;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
            this.val  = i;
        }
    }
}
