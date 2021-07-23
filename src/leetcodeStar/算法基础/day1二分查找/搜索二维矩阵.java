package leetcodeStar.算法基础.day1二分查找;

/**
 * @author aviccii 2021/7/21
 * @Discrimination
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        //构造一个虚数组A[],size m * n ,并非真实构建，了解14行的关联关系即可
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            //A[mid] = matrix[i][j],其中mid=n * i + j,即mid/n = i(j<n,mid/n=n*i/n+j/n=i+0=i),mid % n = j,故x = martix[mid/n][mid%n]
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else return true;
        }
        return false;
    }
}
