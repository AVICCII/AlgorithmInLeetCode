package 牛客;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/7/13
 * @Discrimination
 */
public class NC59_矩阵的最小矩阵和 {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, grid.length - 1, grid[0].length - 1, new HashMap<String, Integer>());
    }

    public int minPathSum(int[][] grid, int i, int j, Map<String, Integer> map) {
        if (i == 0 && j == 0)
            return grid[i][j];
        String key = i + "*" + j;
        if (map.containsKey(key)) return map.get(key);
        //第一行只能从左边走过来
        int res = 0;
        if (i == 0)
            res = grid[i][j] + minPathSum(grid, i, j - 1, map);

            //第一列只能从上面走下来
        else if (j == 0)
            res = grid[i][j] + minPathSum(grid, i - 1, j, map);
            //取从上面走下来和从左边走过来的最小值+当前坐标的值
        else
            res = grid[i][j] + Math.min(minPathSum(grid, i - 1, j, map), minPathSum(grid, i, j - 1, map));
        map.put(key, res);
        return res;
    }


    public int minPathSum2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        //第一列只能从上面走下来
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        //第一行只能从左边走过来
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //递推公式，取从上面走下来和从左边走过来的最小值+当前坐标的值
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum3(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        for (int i = 1; i < r; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < c; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] = Math.min(matrix[i-1][j]+matrix[i][j],matrix[i][j-1]+matrix[i][j]);
            }
        }
        return matrix[r-1][c-1];
    }
}
