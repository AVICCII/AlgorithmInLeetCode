package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/7/20
 * @Discrimination
 */
public class JZ1_二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int r = array.length, c = array[0].length;
        int row = 0, col = c - 1;
        while (row < r && col >= 0) {
            if (array[row][col] > target) col --;
            else if (array[row][col] == target) return true;
            else row++;
        }
        return false;
    }
}
