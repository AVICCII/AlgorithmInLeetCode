package 面试.并发.线程协作;

/**
 * @author aviccii 2021/4/20
 * @Discrimination
 */
public class 线程协作Join {

    public static class JoinExample {
        public class A extends Thread {
            @Override
            public void run() {
                System.out.println("A");
            }
        }

        private class B extends Thread {
            private A a;

            B(A a) {
                this.a = a;
            }

            @Override
            public void run() {
                try {
                    //虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a 线程结束才继续执行，
                    // 因此最后能够保证 a 线程的输出先于 b 线程的输出。
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        }

        public void test() {
            A a = new A();
            B b = new B(a);
            b.start();
            a.start();
        }
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
