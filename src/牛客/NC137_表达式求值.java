package 牛客;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 20:45 2021/7/3
 */
public class NC137_表达式求值 {
    public int solve(String s){
        s = s.trim();
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();
        for (int i = 0, n = charArray.length; i < n; i++) {
            char c = charArray[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (charArray[j] == '(') {
                        counterPartition++;
                    }
                    if (charArray[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
