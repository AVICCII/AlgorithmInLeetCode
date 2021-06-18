package 面试;

/**
 * @author aviccii 2021/6/18
 * @Discrimination
 */
public class foo {
    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {
        int i =0;
        for(foo('A');foo('B')&&(i<2);foo('C'))
        {
            i++;
            foo('D');
        }
    }
}
