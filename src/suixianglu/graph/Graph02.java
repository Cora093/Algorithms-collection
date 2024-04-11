package suixianglu.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph02 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
        graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));

    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    void dfs(int[][] graph, int curIndex) {
        // 终止条件
        if (curIndex == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[curIndex].length; i++) {
            int curNode = graph[curIndex][i];
            path.add(curNode);
            dfs(graph, curNode);
            path.removeLast();
        }
    }
}