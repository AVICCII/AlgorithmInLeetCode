package leetcodeStar.算法基础.day5滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aviccii 2021/7/26
 * @Discrimination
 */
public class 找到字符串的所有字母异位词 {
    //暴力不可取
    public static List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        List<Integer> res = new ArrayList<>();

        char[] charsS = s.toCharArray();
        for (int i = 0; i <= charsS.length - len; i++) {
            char[] temp = new char[len];
            for (int j = 0; j < len; j++) {
                temp[j] = charsS[i + j];
            }
            Arrays.sort(temp);
            if (Arrays.equals(temp, chars)) res.add(i);
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < tLen) return res;

        int[] tCnt = new int[26];
        int[] sCnt = new int[26];

        for (int i = 0; i < tLen; i++) {
            tCnt[t.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCnt, tCnt)) res.add(0);

        for (int i = tLen; i < sLen; i++){
            sCnt[s.charAt(i - tLen) - 'a'] --;
            sCnt[s.charAt(i) - 'a'] ++;
            if (Arrays.equals(sCnt,tCnt)) res.add(i - tLen + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
