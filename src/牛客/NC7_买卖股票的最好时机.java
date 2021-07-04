package 牛客;

import java.util.Arrays;

/**
 * @Author: aviccii
 * @Description:假设你有一个数组，其中第i个元素是股票在第i天的价格，
 * 你有一次买入和卖出的机会，（只有买入该股票才能卖出）。请设计一个算法来计算可以获得的最大收益
 * @Date: Created in 16:14 2021/7/4
 */
public class NC7_买卖股票的最好时机 {
    public  int maxProfit(int[] prices){
        int ans =0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length ; j++) {
                ans = Math.max(prices[j] - prices[i],ans);
            }
        }
        return ans;
    }

}
