package leetcodeStar.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/7/16
 * @Discrimination
 */
public class 字母大小写全排列 {
    static List<String> res = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            else if (i==chars.length-1) flag = true;
        }
        if (flag) {
            res.add(s);
            return res;
        }
        process(chars,0);
        return res;
    }

    public static void process(char[] chars, int i) {
        if (res.contains(String.valueOf(chars))) return;
        if (i == chars.length ) {
            res.add(String.valueOf(chars));
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (chars[j]<='z'&& chars[j] >='a'){
                process(chars,i+1);
                chars[j]=Character.toUpperCase(chars[j]);
                process(chars,i);
            }
            else if (chars[j]<='Z' && chars[j]>='A'){
                process(chars,i+1);
                chars[j]=Character.toLowerCase(chars[j]);;
                process(chars,i);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCasePermutation("3z4");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
