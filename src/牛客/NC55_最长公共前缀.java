package 牛客;

import java.util.Arrays;

/**
 * @author aviccii 2021/7/6
 * @Discrimination
 */
public class NC55_最长公共前缀 {
    public String longestCommonPrefix(String[] strs){
        if (strs == null||strs.length == 0) return "";
        Arrays.sort(strs);

        int len = strs.length;
        int l = Math.min(strs[0].length(),strs[len-1].length());
        int i = 0;
        for (i = 0;i < l;i++){
            if (strs[0].charAt(i) != strs[len - 1].charAt(i)) break;
        }
        return strs[0].substring(0,i);
    }

    public String longestCommonPrefix2(String[] strs){
        if (strs == null||strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) index++;
        return str1.substring(0,index);
    }


}
