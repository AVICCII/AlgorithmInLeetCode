package 左程云.动态规划.动态规划;

import java.util.HashMap;

/**
 * @Author: aviccii
 * @Description:
 * 给定一个字符串str,给定一个字符串类型的数组arr
 * arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 * 返回需要至少多少张贴纸才能完成这个任务
 * 例如：str="babac" arr={"ba","c","abcd"}
 * 至少需要两张贴纸"ba"和"abcd",因为abcd可以剪开使用
 *
 * @Date: Created in 20:31 2021/6/26
 */
public class 题目2 {
    public static int minStickers1(String[] stickers,String target){
        int n = stickers.length;
        int[][] map = new int[n][26];//代表Stickers -> [26] [26] [26]
        HashMap<String,Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c-'a']++;
            }
        }
        dp.put("",0);
        return process1(dp,map,target);
    }

    //dp 傻缓存，如果T已经算过了，直接返回dp的值
    //rest 剩余的目标
    // 0...N 每一个字符串所含字符的词频统计
    private static int process1(HashMap<String, Integer> dp, int[][] map, String rest) {
        if (dp.containsKey(rest)) return dp.get(rest);
        //正式递归调用
        int ans = Integer.MAX_VALUE;
        int n = map.length;//n种贴纸
        //target转换成词频
        int[] tMap = new int[26];
        char[] target = rest.toCharArray();
        for (char c : target) {
            tMap[c - 'a'] ++;
        }

        //map 比对 tMap

        //枚举当前第一张贴纸是谁
        for (int i = 0; i < n; i++) {

            //所有贴纸必须要含有1个target字符才能去尝试
            //如果都没有a,那么说明拼不成，但是如果有1个a,接下来的rest经过57-62行就是有序的了，递归调用会一直调用接下来的字符串
            if (map[i][target[0]-'a']==0) continue;

            StringBuilder sb = new StringBuilder();
            //i是贴纸，j枚举a~z字符
            for (int j = 0; j < 26; j++) {
                if (tMap[j]>0){//该字符需要贴纸
                    //tMap[j]-map[i][j]:当前需要的字符数-该贴纸拥有的对应字符数=剩余需要的字符数
                    //对应在sb上添加剩余需要的字符数
                    for (int k = 0;k<Math.max(0,tMap[j]-map[i][j]);k++) sb.append((char)('a'+j));
                }
            }
            String s = sb.toString();
            //tmp：最终方案得出的最小组成数量
            int tmp = process1(dp,map,s);
            if (tmp != -1) ans = Math.min(ans,1+tmp);
        }

        dp.put(rest,ans == Integer.MAX_VALUE? -1:ans);
        return dp.get(rest);
    }
}
