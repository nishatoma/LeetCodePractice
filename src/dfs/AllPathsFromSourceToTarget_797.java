package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, res, path, 0);

        return res;

    }

    private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int start) {
        if (start == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int child : graph[start]) {
            path.add(child);
            dfs(graph, res, path, child);
            path.remove(path.size() - 1);
        }
    }
}
