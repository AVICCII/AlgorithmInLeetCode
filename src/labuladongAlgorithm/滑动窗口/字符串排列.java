package labuladongAlgorithm.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/1/20
 * @Discrimination
 */
public class 字符串排列 {
    boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.toCharArray()[right];
            right++;
            //窗口内数据更新
            if (need.getOrDefault(c,0) != 0){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.getOrDefault(c,0) == need.getOrDefault(c,0)) valid ++;
            }

            //判断左侧窗口是否需要收缩
            while (right - left >= t.length()){
                //在这里判断是否找到了合法的子串
                if (valid == need.size()) return true;
                char d = s.toCharArray()[left];
                left++;
                //更新数据
                if (need.getOrDefault(d,0)!=0){
                    if (window.getOrDefault(d,0) == need.getOrDefault(d,0)) valid --;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        //未找到
        return false;
    }
}
