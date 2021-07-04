package normal;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 17:35 2021/7/3
 */
public class case451_根据字符出现频率排序 {
    public static String frequencySort(String s){
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        return Arrays.toString(sChar);

    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
