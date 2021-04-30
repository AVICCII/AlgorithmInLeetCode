package normal;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author aviccii 2021/4/30
 * @Discrimination 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class case137只出现一次的数字Ⅱ {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i==nums.length-1) return nums[i];
            else if (nums[i + 2] == nums[i]) {
                i += 2;
            }
            else if (nums[i+2] != nums[i]){
                if (nums[i+1]==nums[i]) return nums[i+2];
                else return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,0,1,0,1,99};
        singleNumber(nums);
        System.out.println(singleNumber(nums));
    }
}
