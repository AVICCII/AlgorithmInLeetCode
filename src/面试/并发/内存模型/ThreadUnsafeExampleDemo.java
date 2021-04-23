package 面试.并发.内存模型;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
//如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。
//
//以下代码演示了 1000 个线程同时对 cnt 执行自增操作，操作结束之后它的值有可能小于 1000。
public class ThreadUnsafeExampleDemo {

    public static class ThreadUnsafeExample{
        private int cnt = 0;

        //这里如果不对cnt加锁，则对于cnt的同时操作可能失效，比如多个线程都同时调用该add方法，那么只算作add一次
        public void add(){
            cnt++;
        }

        public int get(){
            return cnt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
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
