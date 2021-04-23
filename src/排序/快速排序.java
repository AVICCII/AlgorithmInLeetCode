package 排序;

import java.util.Arrays;

/**
 * @author aviccii 2021/3/30
 * @Discrimination
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23,23, -567, 70};
      QuickSort(arr,0,arr.length-1);
    }

    public static void QuickSort(int[] array,int low,int hight){
        //if (array.length < 1 || low < 0 || hight >= array.length || low > hight) return null;
        if(low < hight){
            int privotpos = partition(array,low,hight);
            QuickSort(array,low,privotpos - 1);
            QuickSort(array,privotpos + 1,hight);
        }

    }

    public static int partition(int[] array,int low,int hight){
        int privot = array[low];
        while(low < hight){
            //从后往前找比privot小的
            while(low < hight && array[hight] >= privot) --hight;
            array[low] = array[hight];
            //从前往后找比privot大的
            while(low < hight && array[low] <= privot) ++low;
            //之前比privot小的值替换成找到的比privot大的数
            array[hight] = array[low];
        }
        //当low超过hight说明两边已经有序
        array[low] = privot;
        return low;
    }
}
