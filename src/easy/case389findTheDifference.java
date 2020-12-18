package easy;

import java.util.Arrays;

/**
 * @author aviccii 2020/12/18
 * @Discrimination给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 */
public class case389findTheDifference {

    public static void main(String[] args) {
        findTheDifference4("abcd", "abcde");
    }

    public static char findTheDifference(String s, String t) {

        if (s.length() == 0) return t.charAt(0);

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        char ans = 0;


        Arrays.sort(chars1);
        Arrays.sort(chars2);


        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                ans = chars2[i];
                break;
            }
            if (i == chars1.length - 1) ans = chars2[chars1.length];
        }
        return ans;
    }

    /**
     * 计数方法
     * 遍历字符串，对字符进行计数，当遍历t时出现负数后将其返回。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 求和法
     * 将两个字符串的ascii码进行求和，差值即为被添加字符
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference3(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference4(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

}

