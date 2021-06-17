package 设计模式.单例模式;

/**
 * @author aviccii 2021/5/31
 * @Discrimination
 */
public class Stringtest {
    public static void main(String[] args) {
        String s1 = new String("abcd");
        String s2 = new String("abcd");
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
    }
}
