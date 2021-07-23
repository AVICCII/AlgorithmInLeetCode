package leetcodeStar.算法入门.day13;

/**
 * @author aviccii 2021/7/19
 * @Discrimination
 */
public class _2的幂 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
