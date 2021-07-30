package normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aviccii 2021/7/29
 * @Discrimination
 */
public class case1104_二叉树寻路 {
    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();

        //首先求出label所在的层数
        int level = 1;
        int test = label;
        while (test >> 1 != 0) {
            level++;
            test >>= 1;
        }
        int levelMax = (int) (Math.pow(2, level) - 1);
        int labelPos = 0;
        //如果是偶数层，从0位置数起
        if (level % 2 == 0) {
            labelPos = levelMax - label;
        } else {
            //Math.pow(2,level - 1) - 1对应该层的节点数对应的位置 从0开始所以-1
            labelPos = (int) (Math.pow(2, level - 1) - 1 - levelMax + label);
        }

        res.add(label);

        int levelVal = 0;
        while (level > 1) {
            level--;
            labelPos /= 2;
            if (level % 2 == 0) levelVal = (int) (Math.pow(2, level) - 1) - labelPos;
            else levelVal = (int) Math.pow(2, level - 1) + labelPos;
            res.add(levelVal);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        pathInZigZagTree(9);
    }
}
