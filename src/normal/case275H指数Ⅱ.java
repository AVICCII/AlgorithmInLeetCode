package normal;

/**
 * @author aviccii 2021/7/12
 * @Discrimination
 */
public class case275H指数Ⅱ {
    public int hIndex(int[] citations){
        int times = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i]>times) times++;
        }
        return times;
    }

    public static int hIndex2(int[] citations){
        int n = citations.length;
        int left = 0, right = n -1;
        //这里left需要最终大于right，因为如果右边界划在了最终结果的左边，(citations[mid]==n-mid时也将右边界取mid -1)
        //这里需要left到现在右边界的+1位置，这样正好来到最终结果
        while (left <= right){
            int mid = (left + right) /2;
            //如果citations[mid] >= n - mid,证明mid是符合要求的，但不一定是最小的，所以需要继续判断
            if (citations[mid] >= n - mid) right = mid - 1;
            else left = mid + 1;
        }
        //left是满足要求的最小引用要求数量的文章的位置
        //这里left可以理解满足要求最小位置左边还有Left个数不满足要求，对应总长度n，满足要求的就共计n-left
        return n - left;
    }

    public static void main(String[] args) {
        int[] citations = {0,1,3,5};
        System.out.println(hIndex2(citations));
    }
}
