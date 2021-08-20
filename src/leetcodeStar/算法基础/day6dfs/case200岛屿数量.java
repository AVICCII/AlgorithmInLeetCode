package leetcodeStar.算法基础.day6dfs;

import javafx.stage.Screen;

/**
 * @author aviccii 2021/8/2
 * @Discrimination
 */
public class case200岛屿数量 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    process(grid, i, j);
                }
            }
        }
        return res;
    }

    public void process(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            process(grid, row + 1, col);
            process(grid, row, col + 1);
            process(grid, row - 1, col);
            process(grid, row, col - 1);
        }
    }
}
