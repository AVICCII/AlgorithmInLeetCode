package easy;

/**
 * @author aviccii 2020/8/19
 * @Discrimination 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 */
public class Case27restoreString {
    public String restoreString(String s, int[] indices) {
        char[] chars=new char[s.length()];
        int m=0;
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]]=s.charAt(i);
        }

        return String.valueOf(chars);
    }

}
