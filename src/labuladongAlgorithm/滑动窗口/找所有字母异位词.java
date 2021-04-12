package labuladongAlgorithm.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aviccii 2021/3/19
 * @Discrimination
 */
public class 找所有字母异位词 {

    public static void main(String[] args) {
        String s = "cbaebabacd", t = "abc";
        findAnagrams(s, t);
        System.out.println(findAnagrams(s, t));
    }

    public static List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;

        List<Integer> ans = new ArrayList<>();

        while (right < s.length()) {
            char c = s.toCharArray()[right];
            right++;
            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) valid++;
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) ans.add(left);
                char d = s.toCharArray()[left];
                left++;
                if (need.get(d) != null) {
                    if (window.getOrDefault(d, 0).equals(need.getOrDefault(d, 0))) valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return ans;
    }
}
