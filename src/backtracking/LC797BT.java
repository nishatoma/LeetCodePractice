package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC797BT {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, res, path, 0);
        return res;
    }

    private void backtrack(int[][] graph, List<List<Integer>> res, List<Integer> path, int index) {
        // check index
        if (index >= graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        // Go throug the children
        for (int child : graph[index]) {
            // go throug the rest
            path.add(child);
            backtrack(graph, res, path, child);
            path.remove(path.size() - 1);
        }
    }
}
