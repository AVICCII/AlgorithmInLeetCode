package 左程云.排序;

/**
 * @author aviccii 2021/6/17
 * @Discrimination
 */
public class 插入排序 {

    public static void InsertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int curr = arr[i + 1];
            int index = i;
            while (index >= 0 && arr[index] > curr) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = curr;
        }
    }

    public static void test(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i +1;j>0 && arr[j]<arr[j-1];j --){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

}
