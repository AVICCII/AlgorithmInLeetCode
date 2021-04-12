package JVM;

/**
 * @author aviccii 2021/3/18
 * @Discrimination
 */
public class demoIntern {
    public static void main(String[] args) {
        String x1 = new String("c") + new String("d");
        String x2 = "cd";
        x1.intern();
        System.out.println(x1 == x2);
    }
}
