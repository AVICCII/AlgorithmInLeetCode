package 左程云.排序;

/**
 * @author aviccii 2021/6/17
 * @Discrimination
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 1, 7, 9, 10, 1};
        ShellSort(arr);
    }

    public static void ShellSort(int[] arr) {
        //可以使用knuth序列提升速度
        int knuth = 1;
        while (knuth <= arr.length / 3) knuth = (3 * knuth) + 1;
        int gap = knuth;
        while (gap > 0) {
            for (int i = 0; i < arr.length - gap; i++) {
                for (int j = i + gap; j > gap - 1 && arr[j] < arr[j - gap]; j -= gap) {
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                }
            }
            gap = (gap - 1) / 3;
        }
    }

//    public static void test(int[] arr) {
//        int gap = arr.length / 2;
//        while (gap > 0) {
//            for (int i = 0; i < arr.length - gap; i++) {
//                for (int j = i + gap; j >= gap && arr[j] < arr[j - gap]; j -= gap) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - gap];
//                    arr[j - gap] = temp;
//                }
//            }
//            gap /= 2;
//        }
//    }

    public static void test2(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = 0; i < arr.length -gap; i++) {
                for (int j = i + gap;j>=gap && arr[j-gap] > arr[j];j-=gap){
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j- gap] = temp;
                }
            }
            gap /= 2;
        }
    }
}
