package easy;

/**
 * @author aviccii 2021/7/9
 * @Discrimination摩尔投票法
 */
public class case1710主要元素 {
    public static int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;
    }
    public static void main(String[] args) {
        int[] test = {1,2,5,9,5,9,5,5,5};
        majorityElement(test);
    }
}
