package easy;

/**
 * @author aviccii 2020/10/15
 * @Discrimination 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class Case42toLowerCase {
    public  String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (64<chars[i]&&chars[i]<91){
                chars[i]+=32;
            }
        }
        return String.valueOf(chars);
    }

}
