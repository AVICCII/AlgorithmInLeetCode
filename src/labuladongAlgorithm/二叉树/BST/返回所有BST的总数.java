package labuladongAlgorithm.二叉树.BST;

/**
 * @author aviccii 2021/3/30
 * @Discrimination
 */
public class 返回所有BST的总数 {
    int[][] memo;

    int numTree(int n) {
        //备忘录的值初始化为0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo > hi) return 1;
        //查备忘录
        if (memo[lo][hi] != 0) return memo[lo][hi];

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            //左右子树的组合乘积是BST的总数
            res += left * right;
        }
        //结果存入备忘录
        memo[lo][hi] = res;
        return res;
    }
}
