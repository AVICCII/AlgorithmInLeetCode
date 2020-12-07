package normal;

/**
 * @author aviccii 2020/12/7
 * @Discrimination有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 */
public class case861matrixScore {

    public  int matrixScore(int[][] A) {

        for (int[] ints : A) {
            if (ints[0] == 0) {
                for (int i = 0; i < ints.length; i++) {
                    ints[i] = (ints[i]+3)%2;
                }
            }
        }

        for (int i = 1;i<A[1].length;i++){
            int num  = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] ==1) num ++;
            }
            if (num<=A.length/2){

                for (int j = 0; j < A.length; j++) {
                    A[j][i] = (A[j][i]+3)%2;
                }
            }
        }

        int sum = 0;
        for (int[] ints : A) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < ints.length; j++) {
                sb.append(ints[j]);
            }
            sum += Integer.parseInt(String.valueOf(sb), 2);
        }
        return sum;
    }
}
