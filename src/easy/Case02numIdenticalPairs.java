package easy;

/**
 * @author aviccii 2020/8/11
 * 题目要求：给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 */
public class Case02numIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i]==nums[j]){
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 上述解法为暴力解法。更优解应运用组合知识，即C(n,2)=n(n-1)/2，同时借助哈希表进行实现。
     *   public int numIdenticalPairs2(int[] nums) {
     *         Map<Integer, Integer> m = new HashMap<Integer, Integer>();
     *         for (int num : nums) {
     *             m.put(num, m.getOrDefault(num, 0) + 1);
     *         }
     * 	int ans = 0;
     *     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
     *         int v = entry.getValue();
     *         ans += v * (v - 1) / 2;
     *     }
     *
     *     return ans;
     * }
     */
}
