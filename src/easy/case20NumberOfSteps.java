package easy;

/**
 * @author aviccii 2020/8/17
 */
public class case20NumberOfSteps {
    public int numberOfSteps (int num) {
        int ans=0;
        while (num!=0){
            if(num%2==1){
                num-=1;
            }else {
                num/=2;
            }
            ans++;
        }
        return ans;
    }
}
