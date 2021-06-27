package 左程云.动态规划.动态规划;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 10:48 2021/6/26
 */
public class 字符串转化问题改DP {
    public static int process2(char[] str, int i) {
        if (i == str.length) return 1;

        if (str[i] == '0') return 0;

        if (str[i] == '1') {
            int res = process2(str, i + 1);
            if (i + 1 < str.length) res += process2(str, i + 2); //i+1与i+2构成两位数转换
            return res;
        }

        if (str[i] == '2') {
            int res = process2(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process2(str, i + 2);
            }
            return res;
        }

        return process2(str, i - 1);
    }

    public static int dpWays(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] str = s.toCharArray();
        int N = str.length;

        int[] dp = new int[N + 1];
        dp[N] = 1;
        //dp生成
        for (int i = N - 1; i >= 0; i--){
            if (str[i] == '1'){
                dp[i] = dp[i+1];
                if (i+1 < str.length) dp[i]+=dp[i+2];
                return dp[i];
            }

            if (str[i] == '2') {
                dp[i] = dp[i+1];
                if (i+1 < str.length && (str[i+1]>= '0' && str[i+1] <= '6')) dp[i] +=dp[i+2];
                return dp[i];
            }

            return dp[i+1];
        }


            return dp[0];
    }
}
