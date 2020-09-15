package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2020/9/11
 * @Discrimination
 */
public class plusOne {
    public static int[] plusOne(int[] digits) {
        long  set = 0;
        int i =0;
        for (int length = digits.length; length > 0; length--) {
            set+=digits[i++]*(Math.pow(10,length-1));
            System.out.println(set);
        }
        set+=1;
        List<Integer> list= new ArrayList<>();
        while (set!=0){
            list.add((int) (set%10));
            set=set/10;
        }
        int[] ans =new int[list.size()];
        for (int i1 = 0; i1 < ans.length; i1++) {
            ans[i1]=list.get(list.size()-i1-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] ints = plusOne(a);
        for (int i : ints) {
            System.out.println(i);

        }
    }
}
