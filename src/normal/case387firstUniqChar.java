package normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author aviccii 2020/12/23
 * @Discrimination 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class case387firstUniqChar {

    public static void main(String[] args) {
        String s = "leet";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) map.put(chars[i],1);
            else map.put(chars[i],2);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1) return i;
        }
        return -1;
    }
}
