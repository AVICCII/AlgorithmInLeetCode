package leetcodeStar.day9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author aviccii 2021/7/14
 * @Discrimination
 */
public class 腐败的橘子 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int orangesRotting(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]==2){
                    int code = i * col + j;
                    queue.offer(code);
                    depth.put(code,0);
                }
            }
        }

        while (!queue.isEmpty()){
            int poll = queue.poll();
            int r = poll/col,c = poll%col;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];
                if (nr >=0 && nr < row && nc >= 0 && nc <col && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    int nextCode = nr*col + nc ;
                    queue.offer(nextCode);
                    depth.put(nextCode,depth.get(poll)+1);
                    res = depth.get(nextCode);
                }
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int x=20, y=30;
        boolean b;
        b = x > 50 && y > 60 || x > 50 && y < -60 || x < -50 && y > 60 || x < -50 && y < -60;
        System.out.println(b);

    }
}
