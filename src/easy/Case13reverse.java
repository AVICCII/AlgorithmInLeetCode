package easy;

/**
 * @Author: aviccii
 * @Description:给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Date: Created in 15:57 2020/8/13
<<<<<<< HEAD
 *
=======
>>>>>>> origin/master
 */
public class Case13reverse {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
<<<<<<< HEAD
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
=======
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
>>>>>>> origin/master
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
