package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        // bfs(graph, path, res);
        return res;
    }

    private void bfs(int[][] graph, List<Integer> path, List<List<Integer>> res) {
        Deque<List<Integer>> q = new ArrayDeque<>();
        q.offer(path);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                List<Integer> curr = q.poll();
                int u = curr.get(curr.size() - 1);
                if (u == graph.length - 1) {
                    res.add(curr);
                    continue;
                }

                for (int v : graph[u]) {
                    curr.add(v);
                    q.offer(new ArrayList<>(curr));
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int neighbour : graph[node]) {
                path.add(neighbour);
                dfs(graph, neighbour, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
