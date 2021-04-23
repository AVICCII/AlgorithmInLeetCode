package 动态规划;

/**
 * @author aviccii 2021/4/12
 * @Discrimination
 */
public class 四键盘问题 {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            //按A键
            dp[i] = dp[i - 1] + 1;
            for( int j = 2;j < i;j++)
                //全选 & 复制dp[j-2],连续粘贴i-j次
                //屏幕上共 dp[j-2] * (i-j+1)个A
                dp[i] = Math.max(dp[i],dp[j-2]*(i-j+1));
        }
        //N次按键后最多有几个A？
        return dp[N];
    }

}
