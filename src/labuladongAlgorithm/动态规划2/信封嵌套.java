package labuladongAlgorithm.动态规划2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aviccii 2021/1/21
 * @Discrimination
 */
public class 信封嵌套 {

    //先对w升序，再对h中相同的h降序，再进行最长递增子序列dp
    int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            //按宽度升序排列，如果宽度一样，则将按高度降序排列
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        //对高度数组寻找LTS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) height[i] = envelopes[i][1];

        return 最长递增子序列.lengthOfLIS(height);
    }
}
