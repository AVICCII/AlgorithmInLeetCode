package 左程云.动态规划.动态规划;

/**
 * @Author: aviccii
 * @Description:
 * 假设有排成一行的N个位置，记为1~N，N一定大于或等于2
 * 开始时机器人在其中的M位置上（M一定是1~N中的一个）
 * 如果机器人来到1位置，那么下一步只能往右来到2位置
 * 如果机器人来到N位置，那么下一步只能往左来到N-1位置
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
 * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数N、M、K、P，返回方法数
 *
 *
 * @Date: Created in 8:20 2021/6/26
 */
public class 题目1 {

    public static int ways1(int N,int M,int K,int P){
        if (N < 2|| K<1 || M < 1|| M > N|| P <1 || P> N) return 0;
        return walk(N, M, K, P);
    }

    public static int walk(int N,int cur,int rest,int P){
        //如果没有剩余步数了，当前的cur就是最后的位置
        //判断是否停在了p上
        if (rest == 0) return cur == P ? 1:0;

        //左边界
        if (cur == 1) return walk(N,2,rest -1,P);

        //右边界
        if (cur == N) return walk(N,N-1,rest-1,P);

        //当前位置选择往左走或者往右走，均计数在总步数上，所以相加返回
        return walk(N,cur+1,rest-1,P) + walk(N,cur-1,rest-1,P);
    }


    public static int waysCache(int N, int M,int K,int P){
        if (N < 2|| K<1 || M < 1|| M > N|| P <1 || P> N) return 0;
        int[][] dp = new int[N+1][K+1];
        for (int row = 0; row <= N; row++) {
            for (int col = 0; col <= K; col++) {
                dp[row][col] = -1;//-1表示该位置未计算
            }
        }
        return walk2(N, M, K, P,dp);
    }

    /*
        带减枝的优化
     */
    public static int walk2(int N,int cur,int rest,int P,int[][] dp){
        if (dp[cur][rest] == -1){
            return dp[cur][rest];
        }
        //如果没有剩余步数了，当前的cur就是最后的位置
        //判断是否停在了p上
        if (rest == 0){
            dp[cur][rest] = cur == P?1:0;
            return cur == P ? 1:0;
        }

        //左边界
        if (cur == 1) {
            dp[cur][rest] = walk2(N,2,rest -1,P,dp);
            return walk2(N,2,rest -1,P,dp);
        }

        //右边界
        if (cur == N){
            dp[cur][rest] = walk2(N,N-1,rest -1,P,dp);
            return walk2(N,N-1,rest-1,P,dp);
        }

        //当前位置选择往左走或者往右走，均计数在总步数上，所以相加返回
        dp[cur][rest] = walk2(N,cur+1,rest-1,P,dp) + walk2(N,cur-1,rest-1,P,dp);
        return dp[cur][rest];
    }
}
