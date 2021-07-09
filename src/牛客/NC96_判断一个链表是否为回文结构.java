package 牛客;

import labuladongAlgorithm.basic.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/7/9
 * @Discrimination
 */
public class NC96_判断一个链表是否为回文结构 {
    public boolean isPail (ListNode head){
        ListNode cur = head;
        List<Integer> ans = new ArrayList<>();
        while (cur != null){
            ans.add(cur.val);
            cur = cur.next;
        }
        int start = 0, end = ans.size() - 1;
        while (start < end){
            if (ans.get(start)==ans.get(end)){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }

}
