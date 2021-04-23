package 面试.并发.互斥中断;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
//ReentrantLock 可中断，而 synchronized 不行。
//除非需要使用 ReentrantLock 的高级功能，否则优先使用 synchronized。
// 这是因为 synchronized 是 JVM 实现的一种锁机制，JVM 原生地支持它，而 ReentrantLock 不是所有的 JDK 版本都支持。
// 并且使用 synchronized 不用担心没有释放锁而导致死锁问题，因为 JVM 会确保锁的释放。
public class 互斥同步ReentrantLock {

    public static class LockExample {
        private Lock lock = new ReentrantLock();

        public void func() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + " ");
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(lockExample::func);
        executorService.execute(lockExample::func);
    }

}
