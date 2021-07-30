package leetcodeStar.算法基础.day4双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/7/26
 * @Discrimination
 */
public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null|| secondList == null) return null;
        int firstPtr = 0, secondPtr = 0;
        int firstLen = firstList.length,secondLen = secondList.length;

        List<int[]> res = new ArrayList<>();

        while (firstPtr < firstLen && secondPtr < secondLen){
            int low = Math.max(firstList[firstPtr][0],secondList[secondPtr][0]);
            int high = Math.min(firstList[firstPtr][1],secondList[secondPtr][1]);

            if (low < high) res.add(new int[]{low,high});

            if (firstList[firstPtr][1] < secondList[secondPtr][1]) firstPtr ++ ;
            else secondPtr++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
