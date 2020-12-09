package normal;

/**
 * @author aviccii 2020/12/9
 * @Discrimination 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */

public class Case62uniquePaths {
    public static void main(String[] args) {
        int m = 23, n = 12;
        System.out.println(DpUniquePaths(m, n));
    }

    //组合数学方式求解
    //C (n-1) (m+n-2) = A (m-1) (m+n-2) /(n-1)!=m*(m-1)*...*(m+n-2)/(n-1)!
    //底部从1到n-1阶乘，共n-1-1=n-2次
    //上部从m到m+n-2阶乘，m+n-2-m=n-2次
    //故可以在一个循环中处理结果，避免单次循环中数值溢出问题
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = m, y = 1; y < n; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    //动态规划方式
    //动态规划方程：f(m,n)=f(m-1,n)+f(m,n-1)
    public static int DpUniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        //初始化f
        for (int i = 0; i < m; i++) f[i][0] = 1;
        for (int i = 0; i < n; i++) f[0][i] = 1;
        //dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
