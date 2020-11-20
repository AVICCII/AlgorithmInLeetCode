package normal;

/**
 * @author aviccii 2020/11/20
 * @Discrimination 对链表进行插入排序。
 */
public class Case147insertionSortList {

    public ListNode insertionSortList(ListNode head) {
        //base
        if (head ==null){
            return head;
        }

        //初始化哑节点
        ListNode startNode = new ListNode(0);
        startNode.next = head;

        ListNode lastSortedNode = head,cur = head.next;
        while (cur!=null){
            if (lastSortedNode.val<=cur.val) lastSortedNode = lastSortedNode.next;
            else {
                ListNode pre = startNode;
                while (pre.next.val<=cur.val){
                    pre = pre.next;
                }
                lastSortedNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSortedNode.next;
        }
        return startNode.next;
    }





    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
