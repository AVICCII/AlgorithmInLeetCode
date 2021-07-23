package leetcodeStar.算法入门.day13;

/**
 * @author aviccii 2021/7/19
 * @Discrimination
 */
public class 颠倒二进制位 {
    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << 31 - i;
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        reverseBits(4);
    }
}
