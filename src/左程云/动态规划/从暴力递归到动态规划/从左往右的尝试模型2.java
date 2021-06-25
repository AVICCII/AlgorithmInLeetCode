package 左程云.动态规划.从暴力递归到动态规划;

/**
 * @author aviccii 2021/6/24
 * @Discrimination经典背包问题 给定两个长度都为N的数组weights和values
 * weights[i]和values[i]分别代表i号物品的重量和价值
 * 给定一个正数bag，表示一个载重bag的袋子
 * 你装的物品不能超过这个重量
 * 返回你能装下最多的价值是多少
 */
public class 从左往右的尝试模型2 {

    // index... 最大价值
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) return -1;
        //遍历到最后重量没超，但是index后面没有货了，返回0
        if (index == w.length) return 0;
        //未选择货物
        int p1 = process(w, v, index + 1, alreadyW, bag);
        //选择了货物
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) p2 = v[index] + p2next;

        return Math.max(p1, p2);
    }

    //经典算法

    //只剩下rest的空间了
    //index...货物自由选择，但是剩余空间不要小于0
    //返回index...货物能够获得的最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest <= 0) return -1;
        //rest>0
        if (index == w.length) return 0;

        int p1 = process(w, v, index + 1, rest);
        int p2 = Integer.MIN_VALUE;
        if (rest >= w[index]) p2 = v[index] + process(w, v, index + 1, rest - w[index]);
        return Math.max(p1, p2);
    }
}
