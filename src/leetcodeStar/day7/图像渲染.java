package leetcodeStar.day7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author aviccii 2021/7/12
 * @Discrimination
 */
public class 图像渲染 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

            int currColor = image[sr][sc];
            if (currColor == newColor) {
                return image;
            }
            int n = image.length, m = image[0].length;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = newColor;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                        queue.offer(new int[]{mx, my});
                        image[mx][my] = newColor;
                    }
                }
            }
            return image;
        }


    public static void main(String[] args) {
        int[][] images = {{0, 0, 0}, {0, 1, 1}};
        floodFill(images, 1, 1, 1);
    }
}
