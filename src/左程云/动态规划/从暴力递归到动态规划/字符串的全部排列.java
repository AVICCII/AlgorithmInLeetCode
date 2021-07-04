package 左程云.动态规划.从暴力递归到动态规划;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author aviccii 2021/6/23
 * @Discrimination
 */
public class 字符串的全部排列 {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    //str[0..i-1]已经做好决定
    //Str[i..]都有机会来到i位置
    //i终止位置，加入结果集
    private static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) res.add(String.valueOf(str));
        //如果i没有到中止位置，i...都可以来到i位置
        for (int j = i; j < str.length; j++) {// j i后面所有的字符都有机会
            swap(str, i, j);
            process(str, i + 1, res);
            //恢复现场，i+1递归必须得到最后结果后向上返回，否则无法走下一个分支 **重要
            swap(str, i, j);
        }
    }
    public static void process2(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) res.add(String.valueOf(str));

        //剪枝
        boolean[] visit = new boolean[26];

        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process2(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }


    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
