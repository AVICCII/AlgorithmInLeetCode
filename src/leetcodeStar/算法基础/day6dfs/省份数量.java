package leetcodeStar.算法基础.day6dfs;

/**
 * @author aviccii 2021/8/3
 * @Discrimination 110 110 001
 */
public class 省份数量 {
    static int res;
    public static int findCircleNum(int[][] isConnected) {
        res = isConnected.length;
        int m = isConnected.length,n = isConnected[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                process(isConnected,i,j);
            }
        }
        return res;
    }

    public static void process(int[][] isConnected, int row, int col) {
        if (row < 0 || col < 0 || row >= isConnected.length || col >= isConnected[0].length || isConnected[row][col] == 0)
            return;
        if (row != col && isConnected[row][col] == 1) {
            res--;
            isConnected[col][row] = 0;
        }
        isConnected[row][col] = 0;
        process(isConnected, row + 1, col);
        process(isConnected, row, col + 1);
        process(isConnected, row - 1, col);
        process(isConnected, row, col - 1);
    }


    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(test));
    }
}
