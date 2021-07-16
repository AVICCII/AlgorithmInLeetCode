package leetcodeStar.day7;

/**
 * @author aviccii 2021/7/12
 * @Discrimination
 */
public class 岛屿的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int ans = 0;
                    ans = process(grid, i, j);
                    res = Math.max(res, ans);
                }
            }
        }
        return res;
    }

    public static int process(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == 0) return 0;
        grid[row][column] = 0;
        int ans = 1;
        ans += process(grid, row, column + 1) + process(grid, row + 1, column) + process(grid, row, column - 1)
                + process(grid, row - 1, column);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
