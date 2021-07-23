package labuladongAlgorithm.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/1/19
 * @Discrimination
 */
public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, valid = 0;
        //记录最小覆盖子串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //c是移入窗口的字符
            char c = s.toCharArray()[right];
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.getOrDefault(c, 0) != 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c)) valid++;
            }

            //判断左侧窗口是否要收缩
            while (valid == need.size()) {
                //在这里更新最小子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                char d = s.toCharArray()[left];
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新
                if (need.getOrDefault(d, 0) != 0) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public static String minWindow2(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right = 0;
        int res = 0;
        int start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.getOrDefault(c, 0) != 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) res++;
            }
            while (res == need.size()) {
                //在这里更新最小子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                char d = s.toCharArray()[left];
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新
                if (need.getOrDefault(d, 0) != 0) {
                    if (window.get(d).equals(need.get(d))) res--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
