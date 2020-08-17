package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author aviccii 2020/8/17
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * 请你返回解压后的列表。
 *
 */
public class Case19decompressRleList {

    /**
     * 这里下面的测试通过了，但是在leetcode上编译错误
     * @param nums
     * @return
     */

//    public static void main(String[] args) {
//        int[] test= {2,3,4,5};
//        int[] ints = decompressRleList(test);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//    }

    public static int[] decompressRleList(int[] nums) {

        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            i++;
        }
        int[] ans = new int[sum];
        for (int i = 0; i < nums.length; i++) {
            int mid=nums[i+1];
            for (int j = i; j <= mid; j++) {
                ans[j]=mid;
            }
            i++;
        }

        
        return ans;
    }
    /**
     * class Solution {
     *     public int[] decompressRLElist(int[] nums) {
     *
     *         //如果原数组的长度是否小于1，则返回原数组的第一个元素
     *         if(nums.length <= 1){
     *             return new int[]{nums[0]};
     *         }
     *
     *         //初始化新数组的长度为0
     *         int len = 0;
     *
     *         //遍历原数组，得到新数组的长度
     *         for(int i=0; i<nums.length; i+=2){
     *
     *             len+=nums[i];
     *
     *         }
     *
     *         //初始化新数组
     *         int[] res = new int[len];
     *
     *         //再一次遍历新数组
     *          for(int i=0,j=0;i<nums.length;i+=2){
     *
     *             //对新数组里面的元素进行赋值
     *             for(int k=0; k<nums[i]; k++){
     *
     *                 res[j++] = nums[i+1];
     *
     *             }
     *
     *         }
     *
     *         //返回新数组
     *         return res;
     *
     *     }
     * }
     */
}
