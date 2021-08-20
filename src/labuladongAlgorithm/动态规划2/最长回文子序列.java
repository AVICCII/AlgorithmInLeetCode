package labuladongAlgorithm.动态规划2;

/**
 * @author aviccii 2021/1/25
 * @Discrimination
 */
public class 最长回文子序列 {

    /**
     * dp[i][j]： 子串s[i...j]的最长回文子序列长度
     *bbcb dp[3][3] = 1,dp[2][2] = 1, j = 3, dp[2][3] = max(dp[3][3],dp[2][2]) = 1;
     * dp[1][1] = 1,j= 2, s[1]=b == s[2]=c? false -> dp[1][2] = max(dp[2][1]=0,dp[1][1]=1) = 1;
     * j = 3,s[1]=b == s[3] = b? true = dp[1][3] = dp[2][2]+2 = 3;
     *
     * dp[0][0] = 1,j=1,s[0]==s[1] -> dp[0][1] = dp[1][2] + 2 = 3
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

    public int longestPalindromeSubSeq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
