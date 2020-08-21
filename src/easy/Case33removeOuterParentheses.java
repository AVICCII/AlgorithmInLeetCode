package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2020/8/21
 * @Discrimination 删除最外层的括号
 */
public class Case33removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

}
