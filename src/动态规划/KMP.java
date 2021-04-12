package 动态规划;

/**
 * @author aviccii 2021/4/7
 * @Discrimination
 */
public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        //通过pat构建dp数组
        //需要O(M)时间

        //算法主体
        int M = pat.length();
        //dp[状态][字符] = 下个状态
        dp = new int[M][256];
        //base case
        dp[0][pat.charAt(0)] = 1;
        //影子状态X初始为0
        int X = 0;
        //当前状态j从1开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];
            }
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    //dp[j][c] = next
    //0 <= j < M，代表当前的状态
    //0 <= c < 256，代表遇到的字符（ASCII 码）
    //0 <= next <= M，代表下一个状态
    //
    //dp[4]['A'] = 3 表示：
    //当前是状态 4，如果遇到字符 A，
    //pat 应该转移到状态 3
    //
    //dp[1]['B'] = 2 表示：
    //当前是状态 1，如果遇到字符 B，
    //pat 应该转移到状态 2

    public int search(String txt) {
        //借助DP数组去匹配txt
        //需要O(N)时间
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 当前是状态 j，遇到字符 txt[i]，
            // pat 应该转移到哪个状态？
            j = dp[j][txt.charAt(i)];
            // 如果达到终止态，返回匹配开头的索引
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }


}
