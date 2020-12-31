package normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author aviccii 2020/12/31
 * @Discrimination
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class case435eraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] test = {{1,100},{11,22},{1,11},{2,12}};
//        System.out.println(test[0][0]);
//        System.out.println(test.length);
//        System.out.println(test[0][1]);
        eraseOverlapIntervals(test);
        System.out.println(eraseOverlapIntervals(test));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        /**
         * 未考虑右端点情况
         */
//        //base
//        if (intervals.length==0) return 0;
//        int ans = 0;
//        Stack<Integer> start = new Stack<>();
//        Stack<Integer> end = new Stack<>();
//        start.push(intervals[0][0]);
//        end.push(intervals[0][intervals[0].length-1]);
//
//        for (int i = 1; i < intervals.length; i++) {
//
//            if (intervals[i][0]>=end.peek()) start.push(intervals[i][0]);
//            else {
//                ans++;
//                continue;
//            }
//            if (intervals[i][intervals[i].length-1]>=end.peek()) end.push(intervals[i][intervals[i].length-1]);
//        }
//        return ans;


        /**
         * 官方贪心算法
         */
        if (intervals.length == 0) {
            return 0;
        }

        //筛选所有可以选择的区间中右端点最小的那个区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
