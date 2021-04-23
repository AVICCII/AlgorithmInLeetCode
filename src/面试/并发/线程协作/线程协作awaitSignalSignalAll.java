package 面试.并发.线程协作;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
//相比于 wait() 这种等待方式，await() 可以指定等待的条件，因此更加灵活。
public class 线程协作awaitSignalSignalAll {
    public class AwaitSignalExample{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void before() {
            lock.lock();
            try {
                System.out.println("before");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void after() {
            lock.lock();
            try {
                condition.await();
                System.out.println("after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
