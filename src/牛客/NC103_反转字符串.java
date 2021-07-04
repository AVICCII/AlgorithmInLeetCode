package 牛客;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 20:16 2021/7/3
 */
public class NC103_反转字符串 {
    public static String solve (String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solve("abcde"));
    }
}
