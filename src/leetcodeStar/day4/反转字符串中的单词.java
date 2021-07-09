package leetcodeStar.day4;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/9
 * @Discrimination
 */
public class 反转字符串中的单词 {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        String ans = "";
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                char[] chars1 = s.substring(j, i).toCharArray();
                reverseString(chars1);
                for (char c : chars1) {
                    sBuilder.append(c);
                }
                if (i != chars.length - 1) sBuilder.append(" ");
                j=i+1;
            }
            if (i==chars.length - 1){
                char[] chars1 = s.substring(j, i+1).toCharArray();
                reverseString(chars1);
                for (char c : chars1) {
                    sBuilder.append(c);
                }
            }
        }
        ans = sBuilder.toString();
        return ans;
    }

    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end --;
        }
    }

    public static void main(String[] args) {
//        System.out.println(s.toCharArray()[20]);
        System.out.println(reverseWords("Let's take LeetCode contest"));
//        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
