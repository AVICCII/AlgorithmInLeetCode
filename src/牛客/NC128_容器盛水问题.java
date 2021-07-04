package 牛客;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 18:21 2021/7/4
 */
public class NC128_容器盛水问题 {
    public static long maxWater(int[] arr) {
        if (arr == null || arr.length <=2) return 0;
        int left = 0, right =arr.length -1;
        long sum = 0;
        int mark = Math.min(arr[left], arr[right]);
        while (left < right) {
            // 如果左边较低，则左边界向右遍历， 否则右边界向左移动
            if (arr[left] < arr[right]) {
                left++;
                // 如果当前标尺小于水位，则水量累加
                if (arr[left] < mark) {
                    sum += mark - arr[left];
                } else { // 否则，将此标尺和右边边界高度进行比较，找出剩下数组中的新水位
                    mark = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                // 同理，如果当前标尺小于水位，则水量累加
                if (arr[right] < mark) {
                    sum += mark - arr[right];
                } else { // 否则，将此标尺和左边界的高度进行比较，找出剩余数组中的新水位
                    mark = Math.min(arr[right], arr[left]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,2,4};
        maxWater(arr);
        System.out.println(maxWater(arr));
    }
}
