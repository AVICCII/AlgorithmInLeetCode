package 面试.并发.基本使用;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 继承Thread类 {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("wdnmd");
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
