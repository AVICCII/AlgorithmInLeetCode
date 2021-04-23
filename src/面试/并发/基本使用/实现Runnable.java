package 面试.并发.基本使用;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 实现Runnable {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("wdnmd");
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
