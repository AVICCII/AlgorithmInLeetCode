package SGGAlogrithmDS.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author aviccii 2020/12/7
 * @Discrimination
 */
public class Graph {

    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数
    //定义个数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //测试图是否正确
        int n = 5;//节点个数
        String[] VertexValue = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String Vertex : VertexValue) {
            graph.insertVertex(Vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示
        graph.ShowGraph();
        graph.dfs();
    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    //得到第一个邻接节点的下标w

    /**
     * @param index
     * @return 如果存在就返回对应的下标
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) return i;
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j <vertexList.size();j++){
            if (edges[v1][j]>0) return j;
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是0
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点（输出）
        System.out.print(getValueByIndex(i)+"->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1){
            //说明有邻接节点
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w节点已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的节点，并进行dfs
    public void dfs(){
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    //图中常用的方法
    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回节点i对应的值
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void ShowGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     表示点的下标即是第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
