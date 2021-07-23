package leetcodeStar.算法入门.day13;

/**
 * @author aviccii 2021/7/19
 * @Discrimination
 */
public class 位1的个数 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) ret++;
        }
        return ret;
    }
}
