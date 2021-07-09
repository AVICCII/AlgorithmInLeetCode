package normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/7/8
 * @Discrimination
 */
//假设原数组的前缀和数组为 sum，且子数组 (i,j] 的区间和为goal，那么 sum[j]−sum[i]=goal。因此我们可以枚举 j ，每次查询满足该等式的 i 的数量。
//
//具体地，我们用哈希表记录每一种前缀和出现的次数，假设我们当前枚举到元素 nums[j]，我们只需要查询哈希表中元素 sum[j]−goal 的数量即可，
// 这些元素的数量即对应了以当前 j 值为右边界的满足条件的子数组的数量。最后这些元素的总数量即为所有和为 goal 的子数组数量。
//
//在实际代码中，我们实时地更新哈希表，以防止出现 i≥j 的情况。
//
public class case930_和相同的二元子数组 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            //更新上一个位置的前缀和,重复则添加次数
            cnt.put(sum,cnt.getOrDefault(sum,0) + 1);
            //当前位置j的前缀和
            sum += num;
            //当前位置j有多少个位置i可以满足sum[j] - sum[i] = goal ----> sum[i]=goal - sum[j]
            ret += cnt.getOrDefault(sum - goal,0);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = {1,0,1,0,1};
        numSubarraysWithSum(test,2);
    }
}
