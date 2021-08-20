package 牛客.剑指OFFER;

import java.util.ArrayList;

/**
 * @author aviccii 2021/8/20
 * @Discrimination
 */
public class JZ19顺时针打印矩阵 {

    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        print(0, n - 1, 0, m - 1, matrix);
        return res;
    }

    public void print(int left, int right, int top, int bottom, int[][] matrix) {
        // 从左到右
        for (int i = left; i <= right; i++) res.add(matrix[top][i]);
        // 下一层
        top++;
        if (left > right || top > bottom) return;
        // 从上到下
        for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
        right--;
        if (left > right || top > bottom) return;
        // 从右到左
        for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
        bottom--;
        if (left > right || top > bottom) return;
        // 从下到上
        for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
        left++;
        // 递归
        print(left, right, top, bottom, matrix);
    }
}
