package labuladongAlgorithm.动态规划2;

/**
 * @author aviccii 2021/1/26
 * @Discrimination
 */
public class 最长公共子序列 {

    /**
     * dp[i][j]的定义：对于s1[0..i-1]和s2[0..j-1]，它们的LCS长度是dp[i][j]
     *
     * @param str1
     * @param str2
     * @return
     */
    public int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        //定义:对于s1[0..i-1]和s2[0..j-1],他们的lcs长度是dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //状态转移逻辑
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
