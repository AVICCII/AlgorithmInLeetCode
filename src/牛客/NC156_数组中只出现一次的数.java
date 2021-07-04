package 牛客;

import java.util.HashMap;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 18:10 2021/7/4
 */
public class NC156_数组中只出现一次的数 {
    public int foundOnceNumber(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for (int i : arr) {
            if (map.get(i)==1) return i;
        }
        return 0;
    }
}
