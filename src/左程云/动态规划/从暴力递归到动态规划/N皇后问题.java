package 左程云.动态规划.从暴力递归到动态规划;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 20:23 2021/6/25
 */
public class    N皇后问题 {

    //record[0...i-1]的皇后，任何两个皇后一定都不共行，不共列，不共斜线
    public static int process1(int i,int[] record,int n){
        if (i == n) return 1; //终止行
        //没有到终止位置，还有皇后要摆
        int res = 0;

        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)){
                //进来就会修改值，所以不需要恢复现场
                record[i] = j;//i表示行数，j表示列数，该数组对应键值为放置皇后的位置
                res += process1(i+1,record,n);
            }
        }
        return res;
    }

    public static int num2(int n){
        if (n < 1 || n > 32) return 0;
        //如果是n皇后问题，limit最右n个1，其他都是0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit,0,0,0);
    }

    //limit划定问题的规模 -> 固定
    //colLim 列的限制，1的位置不能放皇后，0的位置可以
    //leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    //rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit,int colLim,int leftDiaLim,int rightDiaLim){
        if (colLim == limit) return 1;//base

        //所有候选皇后的位置都在pos上
        //colLim | leftDiaLim | rightDiaLim代表总限制
        //取反后，是无限制即能选的位置
        //limit & 是截掉左边的0干扰项
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos!=0){
            //一个数字与上自己的取反加一得到最右侧的1
            mostRightOne = pos & (~pos + 1);
            //下一次的位置
            pos = pos - mostRightOne;
            res += process2(limit,colLim|mostRightOne,(leftDiaLim|mostRightOne) << 1,(rightDiaLim|mostRightOne)>>>1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2<<1);
        System.out.println(4>>>1);
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }
}
