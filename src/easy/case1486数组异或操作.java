package easy;

/**
 * @author aviccii 2021/5/7
 * @Discrimination
 */
public class case1486数组异或操作 {

    public static void main(String[] args) {
        System.out.println(xorOperation(4, 3));
    }

    public static int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^=  (start + 2 * i);
        }
        return ans;
    }
}
