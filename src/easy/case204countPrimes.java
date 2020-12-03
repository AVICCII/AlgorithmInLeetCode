package easy;

/**
 * @author aviccii 2020/12/3
 * @Discrimination 统计所有小于非负整数 n 的质数的数量。
 */
public class case204countPrimes {


    public  int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public  boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
