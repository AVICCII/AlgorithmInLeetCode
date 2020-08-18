package easy;

/**
 * @author aviccii 2020/8/18
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 *
 */
public class case21createTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {


        for(int i=0; i < index.length; i++) {
            if (i > index[i]) {
                int t = nums[i];
                for(int j = i-1; j >= index[i]; j--) {
                    nums[j+1] = nums[j];
                }
                nums[index[i]] = t;
            }
        }
        return nums;

    }
}
