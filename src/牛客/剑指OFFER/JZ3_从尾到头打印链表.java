package 牛客.剑指OFFER;

import labuladongAlgorithm.basic.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author aviccii 2021/7/21
 * @Discrimination
 */
public class JZ3_从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) res.add(stack.pop());
        return res;
    }
}
