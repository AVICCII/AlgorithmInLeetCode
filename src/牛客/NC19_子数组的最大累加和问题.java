package 牛客;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 17:49 2021/7/3
 */
public class NC19_子数组的最大累加和问题 {
    public static int maxSumOfSubarray(int[] arr){
        int cur = arr[0];
        int sum = cur;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>cur && cur<0) cur = arr[i];
            else cur += arr[i];
            sum = Math.max(sum,cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
//        maxSumOfSubarray(arr);
        System.out.println(maxSumOfSubarray(arr));
    }
}
