package 牛客;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 16:39 2021/7/4
 */
public class NC1_大数加法 {
    public static String solve(String s,String t){
        int ls = s.length();
        int lt = t.length();
        String s1 = reverse(s);
        String t1 = reverse(t);
        int maxLen = Math.max(ls, lt);

        if (ls > lt){
            for (int i = lt; i < ls; i++) {
                t1 +="0";
            }
        }else {
            for (int i = ls; i < lt; i++) {
                s1 += "0";
            }
        }

        StringBuffer res = new StringBuffer();
        int ans = 0;

        for(int i = 0; i < maxLen; i++){
            int sum = Integer.parseInt(s1.charAt(i)+"") + Integer.parseInt(t1.charAt(i)+"")+ans;
            res.append(sum%10);
            ans = sum/10;  //求出进位数
        }
        if(ans > 0){
            res.append(ans);
        }
        return reverse(new String(res));
    }

    public static String reverse(String str){
        char[] chars = str.toCharArray();
        int l =0,r=chars.length - 1;
        while (l<r){
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "95";
        solve(s1,s2);
    }
}
