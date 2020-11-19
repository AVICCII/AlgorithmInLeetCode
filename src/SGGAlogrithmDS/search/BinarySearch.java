package SGGAlogrithmDS.search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author aviccii 2020/11/18
 * @Discrimination 使用二分查找的前提是该数组是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000,1000,1000,1000, 1234};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
        System.out.println(Collections.unmodifiableList(binarySearch2(arr, 0, arr.length - 1, 1000)));

    }

    //二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到。返回下标 如果没有找到，就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left>right的时候，说明递归整个数组都没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            //向右边递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左边递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //如果出现多个重复字段如何查询到每一个？


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left>right的时候，说明递归整个数组都没有找到
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            //向右边递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左边递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //思路：1.找到mid索引值以后，不立即返回
            //2.向mid索引值的左边扫描，将所有满足1000的元素的下标加入到集合ArrayList
            //3.向mid索引值的右边扫描，将所有满足1000的元素的下标加入到集合ArrayList
            //4.将ArrayList返回
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向左边扫描
            int temp = mid - 1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                //否则就将temp放入到集合resIndexList中
                resIndexList.add(temp);
                temp--;//temp左移
            }
            resIndexList.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

}
