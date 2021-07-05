package 牛客;

/**
 * @author aviccii 2021/7/5
 * @Discrimination
 */
public class NC32_求平方根 {
    public int sqrt(int x){
        for (int i = 0; i < x ; i++) {
            if (Math.pow(i,i)<x) continue;
            else return i-1;
        }
        return 0;
    }
}
