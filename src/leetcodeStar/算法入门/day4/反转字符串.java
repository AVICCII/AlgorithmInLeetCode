package leetcodeStar.算法入门.day4;

/**
 * @author aviccii 2021/7/9
 * @Discrimination
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end --;
        }
    }
}
