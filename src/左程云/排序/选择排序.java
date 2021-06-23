package 左程云.排序;

/**
 * @author aviccii 2021/6/16
 * @Discrimination
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 1, 7, 9, 10};
        SelectSort(arr);
    }

    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
                minIndex = arr[j]<arr[minIndex]? j: minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

//
//    public static void test(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            int index = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[index]> arr[j]) index = j;
//            }
//            int temp = arr[index];
//            arr[index] = arr[i];
//            arr[i] = temp;
//        }
//    }
//
//    public static void test2(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            int index = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[j]<arr[index]) index = j;
//            }
//            int temp = arr[index];
//            arr[index] = arr[i];
//            arr[i] = temp;
//        }
//    }
//

    public static void test3(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i +1 ;j< arr.length;j++){
                if (arr[j]<arr[index]) index = j;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
