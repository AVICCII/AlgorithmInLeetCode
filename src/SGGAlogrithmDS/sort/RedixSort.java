package SGGAlogrithmDS.sort;

import java.util.Arrays;

/**
 * @author aviccii 2020/11/17
 * @Discrimination
 */
public class RedixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void redixSort(int[] arr) {


        //定义一个二维数组，表示十个桶，每个桶是一个一维数组

        //说明
        //1.二维数组包含十个一维数组
        //2.为了防止在放入数的时候数据溢出，只能每个一维数组的长度为arr.length
        //3.很明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        //可以这样理解
        //bucketElementCounts[0]记录的就是第0组中元素的个数
        int[] bucketElementCounts = new int[10];


        //首先得到数组最大的数的位数
        int max = arr[0];//假设第一个数是最大的数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max = arr[i];
        }
        //得到最大位数
        int maxLength = (max+"").length();
        //使用循环处理
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //(针对每个元素的对应位进行排序处理) 第一次是个位，第二次是十位
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个数
                int digitOfeElement = arr[j] /n % 10;
                //放入到对应的桶中
                bucket[digitOfeElement][bucketElementCounts[digitOfeElement]] = arr[j];
                bucketElementCounts[digitOfeElement]++;
            }
            //按照桶的顺序放入原来数组
            int index = 0;
            //遍历每一个桶，并将每一个桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组中
                if (bucketElementCounts[k] != 0) {
                    //循环这个桶取值
                    for (int m = 0; m < bucketElementCounts[k]; m++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][m];
                    }
                }
                //处理后，需要把每个bucketElementCounts[k]=0
                bucketElementCounts[k]=0;
            }


        }


    }
}
