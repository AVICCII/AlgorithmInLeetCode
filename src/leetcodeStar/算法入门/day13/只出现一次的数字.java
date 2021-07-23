package leetcodeStar.算法入门.day13;

/**
 * @author aviccii 2021/7/19
 * @Discrimination
 */
public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
