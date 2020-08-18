package easy;

/**
 * @author aviccii 2020/8/18
 * 统计比现在数据小的数据
 */
public class Case22smallerNumbersThanCurrent {
    /**
     * 暴力方法
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    /**
     * 计数排序
     *
     * public int[] smallerNumbersThanCurrent(int[] nums) {
     *     // 统计出现频率 frequency
     *     int[] freq = new int[101]; // 索引即数值
     *     for (int num : nums) freq[num]++;
     *
     *     // 对频率(而非对原数组nums)从前到后累加
     *     for (int i = 1; i < freq.length; i++) {
     *         freq[i] = freq[i] + freq[i - 1];
     *     }
     *
     *     // 输出结果
     *     int[] res = new int[nums.length];
     *     for (int i = 0; i < res.length; i++) {
     *         if (nums[i] > 0) res[i] = freq[nums[i] - 1];
     *     }
     *     return res;
     * }
     *
     */

}
