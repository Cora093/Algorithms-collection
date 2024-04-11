package suixianglu.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph02 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0){
            return res;
        }
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    void dfs(int[][] graph, int curIndex) {
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