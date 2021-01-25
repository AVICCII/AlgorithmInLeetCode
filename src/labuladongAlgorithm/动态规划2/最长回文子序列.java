package labuladongAlgorithm.动态规划2;

/**
 * @author aviccii 2021/1/25
 * @Discrimination
 */
public class 最长回文子序列 {

    /**
     * dp[i][j]： 子串s[i...j]的最长回文子序列长度
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubSeq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //base
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            //反向遍历保证正确的状态转移
            for (int j = i + 1; j < n; j++) {
                //状态转移
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
