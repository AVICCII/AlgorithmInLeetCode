package 牛客;

import java.util.*;

/**
 * @author aviccii 2021/7/6
 * @Discrimination
 */
public class NC97_字符串出现次数的topK问题 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        if (k == 0) {
            return new String[][]{};
        }
        String[][] res = new String[k][2];
        TreeMap<String, Integer> tmap = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (!tmap.containsKey(s)) {
                tmap.put(s, 1);
            } else {
                tmap.put(s, tmap.get(s) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(tmap.entrySet());
        Collections.sort(list,
                // 先比较值是否相同，相同按键升序进行比较，不相同按值降序比较(值大的在前面)
                (o1, o2) -> (o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()))
        );
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }
}
