package normal;


/**
 * @author aviccii 2020/12/24
 * @Discrimination 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class case135candy {

    public static void main(String[] args) {
        int[] a = {1, 3, 87, 87, 87, 2, 1};
        candy(a);
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
//        左规则：当 ratings[i - 1] < ratings[i] 时，ii 号学生的糖果数量将比 i - 1 号孩子的糖果数量多。

        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        //右规则：当 ratings[i]>ratings[i+1] 时，ii 号学生的糖果数量将比 i + 1 号孩子的糖果数量多。
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
