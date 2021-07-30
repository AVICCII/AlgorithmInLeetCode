package leetcodeStar.算法基础.day4双指针;

/**
 * @author aviccii 2021/7/26
 * @Discrimination
 */
public class 盛最多水的容器 {
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int res = -1;

        while (left < right) {
             res = Math.max((right - left) * Math.min(height[right], height[left]), res);
            if (height[left] < height[right]) left++;
            else right --;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,1}));
    }
}
