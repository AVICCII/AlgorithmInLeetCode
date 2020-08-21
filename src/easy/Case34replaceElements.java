package easy;

/**
 * @author aviccii 2020/8/21
 * @Discrimination 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 */
public class Case34replaceElements {
    public int[] replaceElements(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int big=0;
            for (int i = j+1; i < arr.length; i++) {
                if (big<arr[i]){
                    big=arr[i];
                }
            }
            if(j!=arr.length-1){
                arr[j]=big;
            }else {
                arr[j]=-1;
            }
        }
        return arr;
    }
}
