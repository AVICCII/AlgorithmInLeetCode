package normal;

/**
 * @author aviccii 2021/4/28
 * @Discrimination
 */
public class case633平方数之和 {
    public static   boolean judgeSquareSum(int c) {
        double sqrt = Math.sqrt(c);
        for (int i = 1; i <= (int) sqrt; i++) {
            double v = Math.sqrt( c - Math.pow(i , 2));
            if (v%(int)v==0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        judgeSquareSum(4);
        System.out.println(0.0%0==0);
    }

}
