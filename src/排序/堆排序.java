package 排序;

/**
 * @author aviccii 2021/5/19
 * @Discrimination
 */
public class 堆排序 {
    /*
        调整堆
     */
    public static void heapAdjust(int[] array, int index, int length) {
        //保存当前节点的下标
        int max = index;
        //当前节点左子节点的下标
        int lchild = 2 * index;
        //当前节点右子节点的下标
        int rchild = 2 * index + 1;
        if (length > lchild && array[max]<array[lchild]) max = lchild;
        if (length > rchild && array[max]<array[rchild]) max = rchild;
        if (max != index){
            int temp = array[index];
            array[index] = array[max];
            array[max] = temp;
            heapAdjust(array,max,length);
        }
    }

    /*
    堆排序
     */

    public static int[] heapSort(int[] array){
        int len = array.length;
        //初始化堆，构造一个最大堆
        for (int i = (len/2 - 1);i>=0;i--) heapAdjust(array,i,len);
        //将堆顶的元素和最后一个元素交换,并重新调整堆
        for (int i = len -1;i>0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapAdjust(array,0,i);
        }
        return array;
    }
}
