package labuladongAlgorithm.动态规划;

import java.util.Arrays;

/**
 * @author aviccii 2020/12/28
 * @Discrimination给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class case188maxProfit {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        //buy[i][j] 表示对于数组prices[0..i] 中的价格而言，进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
        //sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                //对于buy[i][j]，我们考虑当前手上持有的股票是否是在第 i 天买入的。如果是第 i 天买入的，那么在第 i−1 天时，
                // 我们手上不持有股票，对应状态 sell[i−1][j]，并且需要扣除 prices[i] 的买入花费；
                // 如果不是第 i 天买入的，那么在第 i−1 天时，我们手上持有股票，对应状态 buy[i][j]。那么我们可以得到状态转移方程：
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                //同理对于 sell[i][j]，如果是第 i 天卖出的，那么在第 i−1 天时，我们手上持有股票，对应状态 buy[i−1][j−1]，
                // 并且需要增加prices[i] 的卖出收益；如果不是第 i 天卖出的，那么在第 i−1 天时，我们手上不持有股票，对应状态sell[i−1][j]。
                // 那么我们可以得到状态转移方程：
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        //由于在所有的 n 天结束后，手上不持有股票对应的最大利润一定是严格由于手上持有股票对应的最大利润的，
        // 然而完成的交易数并不是越多越好（例如数组prices 单调递减，我们不进行任何交易才是最优的），
        // 因此最终的答案即为sell[n−1][0..k] 中的最大值。
        //
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

}
