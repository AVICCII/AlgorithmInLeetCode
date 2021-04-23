package 面试.并发.线程协作;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
public class 线程协作waitNotifyNotifyAll {

    public static class WaitNotifyExample{

        public synchronized void after(){
            try {
                //调用 wait() 使得线程等待某个条件满足，线程在等待时会被挂起
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("after");
        }


        public synchronized void before(){
            System.out.println("before");
            //其它线程会调用 notify() 或者 notifyAll() 来唤醒挂起的线程。
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(example::after);
        executorService.execute(example::before);
    }
}
