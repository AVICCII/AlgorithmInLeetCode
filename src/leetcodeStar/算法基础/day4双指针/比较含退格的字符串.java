package leetcodeStar.算法基础.day4双指针;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author aviccii 2021/7/26
 * @Discrimination
 */
public class 比较含退格的字符串 {
    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String str) {
        StringBuilder ret = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }



    public static void main(String[] args) {
        System.out.println(backspaceCompare("#", "b"));
    }
}
