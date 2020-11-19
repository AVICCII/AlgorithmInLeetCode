package SGGAlogrithmDS.search;

/**
 * @author aviccii 2020/11/18
 * @Discrimination
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    //编写差值查找算法 **同样需要数组有序

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找的值
     * @return 如果找到就返回对应下标，没有找到返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //base
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出Mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 说明应该向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //说明应该向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
