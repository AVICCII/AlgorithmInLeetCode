package easy;

/**
 * @author aviccii 2021/7/30
 * @Discrimination
 */
public class case171Excel表列序号 {
    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();

        int res = 0;
        int times = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i] - 'A' + 1) * Math.pow(26, times++);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
