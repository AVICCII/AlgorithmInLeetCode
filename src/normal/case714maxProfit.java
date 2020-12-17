package normal;

/**
 * @author aviccii 2020/12/17
 * @Discrimination 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class case714maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //定义状态 dp[i][0] 表示第 i天交易完后手里没有股票的最大利润
        // dp[i][1] 表示第 i天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
        // 动态规划转移方程：dp[i][0]=max(dp[i-1][0],dp[i-1][1]+price[i]-fee)
        //dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
        //
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
