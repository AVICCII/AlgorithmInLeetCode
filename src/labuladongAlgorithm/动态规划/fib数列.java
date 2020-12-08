package labuladongAlgorithm.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2020/12/8
 * @Discrimination fib数列只是个例子，并非动态规划问题范畴
 */
public class fib数列 {

    public static void main(String[] args) {
        fib数列 fib数列 = new fib数列();
        fib数列.fib(20);
        System.out.println(fib数列.count1);
        fib数列.fibBetter(20);
        System.out.println(fib数列.count2);

    }

    //传统递归fib
    //携带大量重复子问题

    //测试次数
    public int count1 = 0;
    public int count2 = 0;

    public int fib(int N) {
        count1++;
        if (N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    //通过剪枝方式，将存在巨量冗余的递归树改造
    //这里是自顶向下方式
    public int fibBetter(int N) {
        if (N == 0) return 0;
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    public int helper(int[] memo, int n) {
        count2++;
        //base
        if (n == 1 | n == 2) return 1;
        //已经计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


    //dp数组迭代 自底向上
    public int fibDp(int N){
        if (N==0) return 0;
        if (N==1 || N==2) return 1;
        int[] dp = new int[N+1];
        //base
        dp[1]=dp[2]=1;
        for (int i = 3; i <= N; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[N];
    }

    //自底向上的优化 降低空间复杂度
    public int fibBest(int N){
        if (N ==0 )return 0;
        if (N==1||N==2)return 1;
        int prev = 1,curr= 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev+curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
