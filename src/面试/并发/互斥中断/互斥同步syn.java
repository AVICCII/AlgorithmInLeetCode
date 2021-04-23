package 面试.并发.互斥中断;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 互斥同步syn {

    public static class SynchronizedExample{

        public void func1(){
            //synchronized只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
            synchronized (this){
                for (int i = 0; i < 10; i++) {
                    System.out.print(i+" ");
                }
            }
        }

        public void func2(){
            synchronized (SynchronizedExample.class){
                for (int i = 0; i < 10; i++) {
                    System.out.print(i+" ,");

                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        //对于以下代码，使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，
        // 因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待。
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());

        System.out.println();

        //对于以下代码，两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。从输出结果可以看出，两个线程交叉执行。
        SynchronizedExample e2 = new SynchronizedExample();
        SynchronizedExample e3 = new SynchronizedExample();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(e2::func1);
        executorService2.execute(e3::func1);


    }
}
