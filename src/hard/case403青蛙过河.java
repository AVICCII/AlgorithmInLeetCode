package hard;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author aviccii 2021/4/29
 * @Discrimination 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * <p>
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * <p>
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * <p>
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 */
public class case403青蛙过河 {
    private Boolean[][] rec;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int startPos, int lastStep) {
        //base
        if (startPos == stones.length - 1) return true;
        //check pos
        if (rec[startPos][lastStep] != null) return rec[startPos][lastStep];

        //对三个步长遍历是否有对应的可去点
        for (int curStep = lastStep - 1; curStep <= lastStep + 1; curStep++) {
            int nextStart = Arrays.binarySearch(stones, startPos + 1, stones.length, curStep + stones[startPos]);
            //如果找到合法的可去点，置为true并循环查看下一个可去点是否存在
            if (nextStart >= 0 && dfs(stones, nextStart, curStep)) return rec[startPos][lastStep] = true;
        }
        //该pos未找到可去点，设置为false
        return rec[startPos][lastStep] = false;
    }

}

//DP定义 dp[i][k] 表示青蛙能否达到「现在所处的石子编号」为 i 且「上一次跳跃距离」为 k 的状态。
class DpSolution {
    public boolean canCross(int[] stones){
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0]= true;

        //由结论 11 可知，当青蛙到达第i−1 个石子时，它的「上一次跳跃距离」至多为i−1，因此青蛙在第 i 个石子上最远只能跳出 i 的距离。
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                //我们可以从后向前枚举「上一次所在的石子编号」j，当「上一次跳跃距离」kk 超过了 j+1 时，
                // 我们即可以停止跳跃，因为在第 j 个石子上我们至多只能跳出j+1的距离。
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;

    }

}