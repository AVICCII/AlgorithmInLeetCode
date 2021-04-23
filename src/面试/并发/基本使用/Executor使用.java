package 面试.并发.基本使用;

import 面试.并发.基本使用.实现Runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aviccii 2021/4/19
 * @DiscriminationExecutor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。
 * 这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
 *
 * 主要有三种 Executor：
 *
 * CachedThreadPool：一个任务创建一个线程；
 * FixedThreadPool：所有任务只能使用固定大小的线程；
 * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
 */
public class Executor使用 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new 实现Runnable.MyRunnable());
        }
        executorService.shutdown();

        //守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
        //当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
        //main() 属于非守护线程。
        //在线程启动之前使用 setDaemon() 方法可以将一个线程设置为守护线程。
        Thread thread = new Thread(new 实现Runnable.MyRunnable());
        thread.setDaemon(true);
    }
}
