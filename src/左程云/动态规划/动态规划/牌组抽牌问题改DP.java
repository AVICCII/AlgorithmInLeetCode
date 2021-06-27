package 左程云.动态规划.动态规划;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 16:41 2021/6/26
 */
public class 牌组抽牌问题改DP {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) return 0;
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static int win2ByDP(int[] arr) {
        if (arr.length == 0 || arr == null) return 0;
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
            s[i][i] = 0;//可以不写，初始化的时候就都是0
        }
        for (int i = 1; i < N; i++) {
            int row = 0;
            int col = i;
            //行和列都不越界
            while (row < N && col < N) {
                f[row][col] = Math.max(arr[row] + s[row + 1][col], arr[col] + s[row][col - 1]);
                s[row][col] = Math.max(f[row+1][col],f[row][col-1]);
                row++;
                col++;

            }
        }

        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
}
