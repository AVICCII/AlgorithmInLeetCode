package leetcodeStar.算法基础.day8bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aviccii 2021/8/17
 * @Discrimination 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class 所有可能的路径 {
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> res = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        res.add(0);
        dfs(graph, 0);

        return ans;
    }

    public static void dfs(int[][] graph, int row) {
        for (int i = 0; i < graph[row].length; i++) {
            if (graph[row][i] == graph.length - 1) {
                res.add(graph[row][i]);
                ans.add(new ArrayList<>(res));
            } else {
                res.add(graph[row][i]);
                dfs(graph, graph[row][i]);
            }
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(test);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
