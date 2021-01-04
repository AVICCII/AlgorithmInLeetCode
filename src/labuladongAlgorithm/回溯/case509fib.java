package labuladongAlgorithm.回溯;

/**
 * @author aviccii 2021/1/4
 * @Discrimination
 */
public class case509fib {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        return recursion(n);
    }
    public static int recursion(int n){
        if (n == 1) return 1;
        if (n == 0) return 0;
        return recursion(n-1)+recursion(n-2);
    }
    //DP
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
