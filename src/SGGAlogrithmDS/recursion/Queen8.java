package SGGAlogrithmDS.recursion;

/**
 * @author aviccii 2020/11/6
 * @Discrimination
 */
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array,保存皇后放置位置的结果,比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count+"种解法");
    }


    //编写一个方法，放置第n个皇后
    //特别注意：check是每一次递归时，进入到check方法中都有一次循环
    private void check(int n) {
        if (n == max) {//n=8,其实8个皇后已经放好了
            print();
            return;
        }

        //依次放入，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n]=i;即将第n个皇后放置在本行的后移的一个位置
        }


    }


    //查看当我们放置第n个皇后时 就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示放第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n] ： 判断第n个皇后是否和前面的n-1个皇后在同一列
            //2.Math.abs(n-1) == Math.abs(array[n]-array[i])：表示判断第n个皇后是否和第i皇后在同一斜线
            //3.判断是否在同一行没有必要。因为n每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    //写一个方法可以将皇后摆放的位置打印出来
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        count++;
        System.out.println();
    }
}
