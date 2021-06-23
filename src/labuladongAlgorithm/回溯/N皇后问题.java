package labuladongAlgorithm.回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aviccii 2020/12/9
 * @Discrimination
 */
public class N皇后问题 {
    List<List<String>> res = new LinkedList<>();


    //输入棋盘边长为n，返回所有合法的放置方法
    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            //'.'表示空，'Q'表示皇后，初始化空棋盘
            Arrays.fill(arr, '.');
            board.add(arr);
        }
        backtrack(board, 0);
        return res;
    }


    //路径：board中小于row的那些行都已经成功放置了皇后
    //选择列表：第row行的所有列都是放置皇后的选择
    void backtrack(List<char[]> board, int row) {
        //结束条件：row超过board的最后一行，说明棋盘放满了
        if(row == board.size()){ //触发结束条件
            res.add(transform(board));
        }

        int n = board.size();
        //遍历所有选择
        for(int col = 0; col < n; col++){
            if(!isValid(board, row, col)){ //剪枝
                continue;
            }

            //做出选择
            board.get(row)[col] = 'Q';
            //进入下一行决策
            backtrack(board, row + 1);
            //撤销选择
            board.get(row)[col] = '.';
        }
    }

    List<String> transform(List<char[]> board){
        List<String> newBoard = new LinkedList<>();
        for(char[] row : board){
            newBoard.add(new String(row));
        }

        return newBoard;
    }

    Boolean isValid(List<char[]> board, int row, int col) {
        int n = board.size();
        for(int i = 0; i < n; i++) { // 检查列是否有皇后互相冲突
            if(board.get(i)[col] == 'Q'){
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--,j++){
            if(board.get(i)[j] == 'Q'){
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board.get(i)[j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
