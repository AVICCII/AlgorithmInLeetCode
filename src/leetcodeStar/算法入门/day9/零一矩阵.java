package leetcodeStar.算法入门.day9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aviccii 2021/7/14
 * @Discrimination
 */
public class 零一矩阵 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] ans = new int[row][col];
        boolean[][] checked = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    checked[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < row && nj >= 0 && nj < col && !checked[ni][nj]) {
                    ans[ni][nj] = ans[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    checked[ni][nj] = true;
                }
            }
        }
        return ans;
    }
}



