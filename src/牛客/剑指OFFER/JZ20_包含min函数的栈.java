package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/8/20
 * @Discrimination
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class JZ20_包含min函数的栈 {

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
