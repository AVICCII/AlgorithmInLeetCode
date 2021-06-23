package 左程云.动态规划.从暴力递归到动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author aviccii 2021/6/23
 * @Discrimination
 */
public class 字符串的所有非重复子序列 {

    public static void process2(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }

        String no = path;
        process2(str, index, set, no);
        String yes = path + String.valueOf(str[index]);
        process2(str, index, set, yes);
    }

    public static List<String> subsNoRepeat(String s){
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set =new HashSet<>();
        process2(str,0,set,path);
        List<String> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }
}
