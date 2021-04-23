package 面试.并发.基本使用;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 实现Callable接口 {
    public static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return 123;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        //返回值需要通过FutureTask进行封装
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
