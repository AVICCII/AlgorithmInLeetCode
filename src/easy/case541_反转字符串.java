package easy;

/**
 * @author aviccii 2021/8/20
 * @Discrimination 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class case541_反转字符串 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length(), rest = s.length();

        int leftPos = 0;
        while (rest > 0) {
            if (rest < k) {
                reverse(chars, leftPos, rest);
                return new String(chars);
            }

            if (rest < 2 * k) {
                reverse(chars, leftPos, k);
                return new String(chars);
            }

            reverse(chars, leftPos, k);
            rest -= 2 * k;
            leftPos += 2 * k;
        }
        return new String(chars);

    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
