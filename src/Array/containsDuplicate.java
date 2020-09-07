package Array;

/**
 * @author aviccii 2020/9/7
 * @Discrimination 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 暴力法 超时
 */
public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                     ans=true;
                    break;
                }
            }
        }
        return ans;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x:nums){
            if (set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
