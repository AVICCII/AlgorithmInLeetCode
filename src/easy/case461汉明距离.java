package easy;

/**
 * @author aviccii 2021/5/27
 * @Discrimination
 */
public class case461汉明距离 {
        public int totalHammingDistance(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < 30; ++i) {
                int c = 0;
                for (int val : nums) {
                    c += (val >> i) & 1;
                }
                ans += c * (n - c);
            }
            return ans;
        }

}
