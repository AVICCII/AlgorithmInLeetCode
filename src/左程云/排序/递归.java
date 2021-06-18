package 左程云.排序;

/**
 * @author aviccii 2021/6/17
 * @Discrimination
 */
public class 递归 {

    public static void main(String[] args) {
        System.out.println(f(10));
    }

    static long f(int n){
        if (n < 1) return -1;
        if (n == 1) return 1;
        return n + f(n-1);
    }
}
