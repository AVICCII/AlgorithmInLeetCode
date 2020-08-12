package easy;

/**
 * @author aviccii 2020/8/12
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 */
public class Case11subtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int sum=1;
        int num=0;
        while(n>0){
            int target= n%10;
            n/=10;
            sum*=target;
            num+=target;
        }
        return sum-num;
    }
}
