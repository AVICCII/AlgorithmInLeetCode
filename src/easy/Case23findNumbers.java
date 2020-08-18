package easy;

/**
 * @author aviccii 2020/8/18
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class Case23findNumbers {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int i:nums){
            if(String.valueOf(i).length()%2==0){
                res++;
            }
        }

        return res;
    }

}
