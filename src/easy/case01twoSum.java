package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/1/14
 * @Discrimination
 */
public class case01twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) return new int[]{i, hashmap.get(target - nums[i])};
            hashmap.put(nums[i], i);
        }
        return new int[0];
    }

    //暴力
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        return new int[0];
    }
}

