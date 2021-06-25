package 左程云.动态规划.从暴力递归到动态规划;

/**
 * @author aviccii 2021/6/24
 * @Discrimination 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的指派
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数
 */
public class 范围上尝试的模型 {

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }
    //先手
    public static int f(int[] arr, int i, int j){
        if (i == j) return arr[i];
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }
    //后手
    //i..j
    public static int s(int[] arr,int i,int j){
        if (i == j) return 0;
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }
}
