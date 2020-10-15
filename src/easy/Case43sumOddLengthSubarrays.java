package easy;

/**
 * @author aviccii 2020/10/15
 * @Discrimination 所有可能的奇数长度子数组的和。
 */
public class Case43sumOddLengthSubarrays {
    public static int sumOddLengthSubarrays(int[] arr) {
        int  sum = 0;
        for (int i = 0; i < arr.length; i++) {
            i++;
            int num = arr.length-i+1;
            for (int j = 0; j < num; j++) {
                for (int m = 0; m < i; m++) {
                    sum+=arr[j+m];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(a));
    }

}
