package easy;

/**
 * @author aviccii 2020/8/11
 *
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 */
public class Case04shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];
        int j=0;
        for (int i = 0; i <n; i++) {
            answer[j++]=nums[i];
            answer[j++]=nums[n+i];
        }
        return answer;
    }
}
