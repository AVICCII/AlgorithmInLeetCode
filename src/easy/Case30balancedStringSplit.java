package easy;

/**
 * @author aviccii 2020/8/20
 * @Discrimination
 */
public class Case30balancedStringSplit {
    public int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
            {num++;}
            else{
                num--;
            }
            if(num == 0) {
            }
            res++;
        }
        return res;
    }

    }
