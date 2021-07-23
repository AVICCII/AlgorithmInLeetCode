package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/7/22
 * @Discrimination
 */
public class JZ6_旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int l = 0, r = array.length - 1;

        while (l < r){
            if (array[l] < array[r]) return array[l];
            int mid = l + (r - l) >> 1;
            if (array[mid] < array[r]) r = mid;
            else if (array[mid] > array[r]) l = mid + 1;
            else l++;
        }
        return array[l];
    }
}
