package SGGAlogrithmDS.recursion;

/**
 * @author aviccii 2020/11/5
 * @Discrimination
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        //设置挡板
        map[3][1]=1;
        map[3][2]=1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1,1);

        System.out.println("==========================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    //使用递归回溯来给小球找路
    //说明
    //ij表示从地图的哪个位置开始出发(1,1)
    //如果小球能到(6,5)的位置，说明通路找到
    //当map[i][j]为0表示该点没有走过 当为1表示墙 2表示这条路可以走通 3表示已探测过，但不通
    //走迷宫的策略：首先确定一个。 下 右 上 左 该点走不通则回溯
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            //通路已经找到
            return true;
        }else {
            if (map[i][j]==0){
                //当前这个点还没有走过
                //按照策略走
                map[i][j]=2;//假定这个点能走通
                if (setWay(map,i+1,j)){
                    return true;
                    //向下走
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                //如果map[i][j]！=0
                return false;
            }
        }
    }
}
