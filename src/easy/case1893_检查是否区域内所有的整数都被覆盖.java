package easy;

/**
 * @author aviccii 2021/7/23
 * @Discrimination
 */
public class case1893_检查是否区域内所有的整数都被覆盖 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];  //差分数组
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        //前缀和
        int curr = 0;
        for (int i = 0; i <= 50; i++) {
            curr += diff[i];
            if ( i >= left && i <= right && curr <= 0) return false;
        }
        return true;
    }

    public static boolean isCovered2(int[][] ranges, int left, int right) {
        for (int[] range : ranges) {
            if (range[0] <=left && left>=range[1]) left = range[1] + 1;
        }
        return left>right;
    }


    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1, 50}};
        System.out.println(isCovered(ranges, 1, 50));
    }
}
