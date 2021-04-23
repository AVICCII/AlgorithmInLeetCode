package 面试.并发.concurrent包;

import java.util.concurrent.*;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
//主要用于并行计算中，和 MapReduce 原理类似，都是把大的计算任务拆分成多个小任务并行计算。
public class concurrent包中的ForkJoin {


    public static class ForkJoinExample extends RecursiveTask<Integer> {

        private final int threshold = 5;
        private int first;
        private int last;

        @Override
        protected Integer compute() {
            int res = 0;
            if (last - first <= threshold) {
                //任务足够小则直接计算
                for (int i = first; i <= last; i++) {
                    res += i;
                }
            } else {
                //拆分成小任务
                int middle = first + (last - first) / 2;
                ForkJoinExample leftTask = new ForkJoinExample(first, middle);
                ForkJoinExample rightTask = new ForkJoinExample(middle + 1, last);
                leftTask.fork();
                rightTask.fork();
                res = leftTask.join() + rightTask.join();
            }
            return res;

        }

        public ForkJoinExample(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample example = new ForkJoinExample(1, 10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future res = forkJoinPool.submit(example);
        System.out.println(res.get());
    }

}
