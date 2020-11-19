package Array;

/**
 * @author aviccii 2020/9/15
 * @Discrimination 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

/**
 * 暴力
 */
public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                for (int j = i+1;j<nums.length;j++){
                    if (nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 一次遍历
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] num1=new int[]{0,1,2,3,4,0};
        moveZeroes1(num1);
        for (int i : num1) {
            System.out.println(i);
        }
    }
}
