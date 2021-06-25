package 剑指offer;

import java.util.Arrays;

/**
 * @author aviccii 2021/6/24
 * @Discrimination
 */
public class case10斐波那契数列 {
    public int fib(int n) {
        int a = 0,b = 1,sum;
        for(int i = 0;i< n;i++){
            //大数越界
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
