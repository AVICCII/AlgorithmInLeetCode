package normal;

import java.util.*;

/**
 * @author aviccii 2020/12/14
 * @Discrimination
 */
public class case49groupAnagrams {


    public static void main(String[] args) {
        Map<Character,Integer> ansMap = new HashMap<>();
        Map<Character,Integer> ansMapMid = new HashMap<>();
        ansMap.put('c',1);
        ansMap.put('a',1);
        ansMap.put('b',1);
        ansMap.putAll(ansMapMid);
        ansMapMid.remove('a');
        System.out.println(ansMap.get('a'));
        System.out.println(ansMapMid.get('a'));
    }



    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
