package SGGAlogrithmDS.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author aviccii 2020/11/6
 * @Discrimination
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, 10, 10, 20};

        int[] arrTest = new int[80000];
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random()*800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序开始时间"+date1Str);

        bubbleSort(arrTest);

      Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序结束时间"+date2Str);


    }

    public static void bubbleSort(int[] arr){
        //第一趟排序，就是将最大的数排在最后
        int temp = 0;//临时变量
        boolean flag = false;//标识变量，标识是否进行过交换
        for (int j= 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 -j; i++) {
                //如果前面的数比后面的数大，则交换
                if (arr[i] > arr[i + 1]) {
                    flag=true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
//            System.out.println("第"+(j+1)+"躺排序的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag){
                //在一趟排序中一次排序都没发生
                break;
            }else {
                flag=false;//进行下一次判断
            }
        }
    }
}
