package 左程云.动态规划.动态规划;

import java.util.HashMap;

import static 左程云.动态规划.动态规划.背包问题改动态规划.process;

/**
 * @Author: aviccii
 * @Description: 给定数组arr, arr中所有的值都为正数且不重复
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 在给定一个正数aim,代表要找的钱数
 * 求组成aim的方法数
 * @Date: Created in 11:02 2021/6/26
 */
public class 货币问题转DP {

    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
//        if (rest < 0) return 0;  在下面调用的时候就保证了rest不会小于0
        if (index == arr.length) return rest == 0 ? 1 : 0;
        //当前有货币arr[index]
        int ways = 0;
        for (int num = 0; num * arr[index] <= rest; num++) {
            ways += process(arr, index + 1, rest - arr[index] * num);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 | aim < 0) return 0;

//        HashMap<String,Integer> map = new HashMap<>();
        //index = 3 rest = 900 map key"3_900" value returnValue
        int[][] dp = new int[arr.length + 1][aim + 1];
        //一开始所有的过程都没有计算
        //dp[..][..] = -1

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }


        return process2(arr, 0, aim, dp);
    }


    //如果index和rest的参数组合，是没算过的，dp[index][rest] == -1
    //如果index和rest的参数组合，是算过的，dp[index][rest] >-1
    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) return dp[index][rest];

        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int num = 0; num * arr[index] <= rest; num++) {
            ways += process(arr, index + 1, rest - arr[index] * num);
        }
        return ways;
    }


    public static int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 | aim < 0) return 0;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;//dp[arr.length]{1...aim]=0


        //行
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest < aim; rest++) {
                int ways = 0;
                for (int num = 0;num * arr[index] <= rest;num++) ways +=dp[index+1][rest - arr[index]*num];
                dp[index][rest] = ways;
            }
        }


        return dp[0][aim];
    }



    public static int ways4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 | aim < 0) return 0;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;//dp[arr.length]{1...aim]=0
        //行
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest < aim; rest++) {
                //自己下方的数值
                dp[index][rest] = dp[index+1][rest];
                //自己左边间隔的dp[index][rest-arr[index]]已经算过前面对应间隔arr[index]所有的值了，所以将下方和左边最近的
                //间隔dp[index][rest-arr[index]]相加即可，省去了80行的枚举过程
                if (rest - arr[index] >= 0) dp[index][rest] += dp[index][rest-arr[index]];
            }
        }


        return dp[0][aim];
    }

}


















