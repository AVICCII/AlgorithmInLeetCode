package 面试.并发.无同步方案;

/**
 * @author aviccii 2021/4/21
 * @Discrimination
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();

        Thread thread1 = new Thread(() ->{
            threadLocal1.set(1);
            threadLocal2.set(2);
        });

        Thread thread2 = new Thread(() ->{
            threadLocal1.set(2);
            threadLocal2.set(2);
        });

        thread1.start();
        thread2.start();
        System.out.println(threadLocal1.get());
        System.out.println(threadLocal2.get());
    }
}
