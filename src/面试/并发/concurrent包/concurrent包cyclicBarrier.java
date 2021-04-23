package 面试.并发.concurrent包;

import java.util.concurrent.*;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
//用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
//CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，所以它才叫做循环屏障。
public class concurrent包cyclicBarrier {
    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.println("before...");
                try {
                    //和 CountdownLatch 相似，都是通过维护计数器来实现的。
                    // 线程执行 await() 方法之后计数器会减 1，并进行等待。
                    cyclicBarrier.await();
                }catch (InterruptedException| BrokenBarrierException e){
                    e.printStackTrace();
                }
                //直到计数器为 0，所有调用 await() 方法而在等待的线程才能继续执行。
                System.out.println("after...");
            });
        }
        executorService.shutdown();
    }
}
