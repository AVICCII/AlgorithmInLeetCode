package 排序;

import java.util.ArrayList;

/**
 * @author aviccii 2021/6/15
 * @Discrimination
 */
public class 桶排序 {

    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) return array;
        int max = array.get(0), min = array.get(0);
        //找到最大最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) max = array.get(i);
            if (array.get(i) < min) min = array.get(i);
        }
        int bucketCount = (max - min) /bucketSize - 1;
        ArrayList<ArrayList<Integer>>  bucketArr= new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        //构造桶
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //往桶里赛数据
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min)/bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1){
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else {
                if (bucketCount == 1) bucketSize --;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i),bucketSize);
                for (int j = 0;j < temp.size();j++) resultArr.add(temp.get(i));
            }
        }
        return resultArr;
    }
}
