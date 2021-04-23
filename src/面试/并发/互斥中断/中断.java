package 面试.并发.互斥中断;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 中断 {
    public static class InterruptExample{
        private static class MyThread1 extends Thread{
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread run");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        private static class MyThread2 extends Thread{
            @Override
            public void run() {
                //如果一个线程的 run() 方法执行一个无限循环，
                // 并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt() 方法就无法使线程提前结束。
                //但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。
                // 因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。
                while (!interrupted()) System.out.println("wdnmd");
                System.out.println("Thread end");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new InterruptExample.MyThread1();
        myThread1.start();
        myThread1.interrupt();

        //--------------------------------------------------
        //interrupted使用
        System.out.println("Main run");
        Thread myThread2 = new InterruptExample.MyThread2();
        myThread2.start();
        myThread2.interrupt();


        //调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，
        // 但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
        //以下使用 Lambda 创建线程，相当于创建了一个匿名内部线程。
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("main run");
    }
}
