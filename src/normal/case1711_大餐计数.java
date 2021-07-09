package normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/7/7
 * @Discrimination
 */
public class case1711_大餐计数 {
    public static int countPairs(int[] deliciousness){
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(i,maxVal);
        }
        int MaxSum = 2 * maxVal;
        int pairs = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int val = deliciousness[i];
            for (int sum = 1;sum <= MaxSum;sum <<= 1){
                int count = map.getOrDefault (sum - val,0);
                pairs = (pairs + count) % MOD;
            }
            //哈希表中已有的元素的下标一定小于当前元素的下标，因此任意一对元素之和等于 2 的幂的元素都不会被重复计算。
            map.put(val,map.getOrDefault(val,0)+1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr ={ 1,3,5,7,9};
        countPairs(arr);
    }
}
