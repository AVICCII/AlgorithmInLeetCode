package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/1/14
 * @Discrimination
 */
public class case1018prefixesDivBy5 {


    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = (temp * 2 + A[i] )% 5 ;
            ans.add(temp == 0);
        }
        return ans;
    }
}
