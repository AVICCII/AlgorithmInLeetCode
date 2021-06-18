package 左程云.排序;

/**
 * @author aviccii 2021/6/16
 * @Discrimination
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 1, 7, 9, 10};
        BubbleSort(arr);
    }

    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int k = 0;
            int j = 1;
            while (j < arr.length - i){
                if (arr[k]>arr[j]){
                    int temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                }
                k++;
                j++;
            }
        }
    }

//    public static void test(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }


    public static void test2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
