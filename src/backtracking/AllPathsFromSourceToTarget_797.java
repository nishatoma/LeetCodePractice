package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return null;
        int n = graph.length;
        List<Integer> curr = new ArrayList<>();
        // Add the first node
        curr.add(0);
        List<List<Integer>> res = new ArrayList<>();

        dfs(graph, 0, n - 1, curr, res);

        return res;
    }

    private void dfs(int[][] graph, int source, int target, List<Integer> curr, List<List<Integer>> res) {
        if (source == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int child : graph[source]) {
            curr.add(child);
            dfs(graph, child, target, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
