package 左程云.动态规划.动态规划;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 10:00 2021/6/26
 */
public class 背包问题改动态规划 {

    public static int maxValue(int[] w,int[] v,int bag){
        return process(w,v,0,bag);
    }

    public static int process(int[] w,int[] v,int index,int rest){
        if (rest< 0) return -1;

        if (index == w.length) return 0;

        int p1 = process(w,v,index+1,rest);

        int p2 = process(w,v,index+1,rest- w[index]);

        if (p2 != -1) p2 =   v[index]+p2;
        return Math.max(p1,p2);
    }

    public static int dpWay(int[] w,int[] v,int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        for (int index = N -1;index >= 0;index --){
            for (int rest = 0; rest <= bag; rest++) {
                dp[index][rest] = dp[index+1][rest];
                //rest - w[index] >= 0 确保不越界
                if (rest- w[index] >= 0) dp[index][rest] = Math.max(dp[index][rest],v[index]+dp[index+1][rest-w[index]]);
            }
        }

        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3,2,4,7};
        int[] values = {5,6,3,19};
        int bag = 11;
        System.out.println(maxValue(weights,values,bag));
        System.out.println(dpWay(weights,values,bag));
    }
}
