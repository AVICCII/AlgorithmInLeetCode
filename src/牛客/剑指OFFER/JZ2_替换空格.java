package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/7/21
 * @Discrimination
 */
public class JZ2_替换空格 {
    public static String replaceSpace(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            }
            else sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        String newStr = new String(array, 0, index);
        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("abc abc"));
    }
}
