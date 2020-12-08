package labuladongAlgorithm.动态规划;

import java.util.Arrays;

/**
 * @author aviccii 2020/12/8
 * @Discrimination
 */
public class 凑零钱问题 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }

    /**
     * @param coins  可选硬币面值
     * @param amount 目标金额
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //base
        dp[0] = 0;

        //外层for循环遍历所有状态的取值
        for (int i = 0; i < dp.length; i++) {
            //内层循环求所有选择的最小值
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
