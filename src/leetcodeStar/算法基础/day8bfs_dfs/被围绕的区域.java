package leetcodeStar.算法基础.day8bfs_dfs;

/**
 * @author aviccii 2021/8/17
 * @Discrimination
 */
public class 被围绕的区域 {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        if (row == 0) return;

        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }

        for (int i = 0; i < (col - 1); i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row >= board.length - 1 || col >= board[0].length - 1 || row < 0 || col < 0 || board[row][col] != 'O')
            return;
        board[row][col] = 'A';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
