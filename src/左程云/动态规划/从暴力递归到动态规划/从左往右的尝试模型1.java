package 左程云.动态规划.从暴力递归到动态规划;

/**
 * @author aviccii 2021/6/24
 * @Discrimination 规定1=A,2=B,3=C... 那么数字字符串111可以为AAA,KA,AK
 * 给定一个只有数字字符组成的字符串str,返回有多少种转化结果
 */
public class 从左往右的尝试模型1 {

    //str[0...i-1]已经转换完
    //i之前的位置，如何转化已经做过决定了
    //i... 有多少种转化结果
    public static int process(char[] str,int i){
        if (i == str.length) return 1;//终止条件
        if (str[i] == '0') return 0; //i没有到终止位置,为0不符合条件
        //str[i]不是0
        if (str[i] == '1'){
            int res = process(str,i+1);//i自己作为单独的部分，后续有多少种方法
            if (i+1 <str.length) res += process(str,i+2); //i+1与i+2构成两位数转换
            return res;
        }

        if (str[i] == '2') {
            int res = process(str,i+1);//i自己作为单独的部分，后续有多少种方法
            //(i和i+1)作为单独的部分并且没有超过26，后续有多少种方法
            if (i + 1< str.length && (str[i+1] >= '0' && str[i+1] <= '6')){
                res+=process(str,i+2);
            }
            return res;
        }
        //str[i] == '3'~'9'不考虑
        return process(str, i -1);
    }
}
