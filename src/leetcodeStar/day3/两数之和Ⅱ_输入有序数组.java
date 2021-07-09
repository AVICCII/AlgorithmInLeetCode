package leetcodeStar.day3;

/**
 * @author aviccii 2021/7/8
 * @Discrimination
 */
public class 两数之和Ⅱ_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) return new int[]{start + 1, end + 1};
            else if (numbers[start] + numbers[end] < target) start++;
            else end--;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
