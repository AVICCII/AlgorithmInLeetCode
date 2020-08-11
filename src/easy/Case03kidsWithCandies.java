package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2020/8/11
 * 题目要求：给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
 * 注意，允许有多个孩子同时拥有 最多 的糖果数目。
 */
public class Case03kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max=0;
        int length = candies.length;
        for (int i = 0; i < length; i++) {
             max = Math.max(max, candies[i]);
        }
        List<Boolean> answer = new ArrayList<Boolean>();
        for (int i = 0; i < length; i++) {
            answer.add(candies[i]+extraCandies>=max);
        }
        return answer;
    }
/**
 * 复杂度分析
 * 时间复杂度：使用O(n)时间预处理出所有小朋友拥有的糖果数目最大值。对于每一个小朋友，我们需要O(1)的时间判断是否可以拥有最多的糖果。
 *      因此时间复杂度为：O(n)
 * 空间复杂度：这里只用了常数个变量作为辅助空间，与n的规模无关，故渐进空间复杂度为O(1)。
*/
 }

