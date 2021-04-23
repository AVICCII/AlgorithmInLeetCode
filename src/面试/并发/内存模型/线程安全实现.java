package 面试.并发.内存模型;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author aviccii 2021/4/21
 * @Discrimination
 */
public class 线程安全实现 {
    public static class AtomicExample{
        //AtomicInteger 能保证多个线程修改的原子性。
        private AtomicInteger cnt = new AtomicInteger();

        public void add(){
            cnt.incrementAndGet();
        }

        public int get(){
            return cnt.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        AtomicExample example = new AtomicExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
