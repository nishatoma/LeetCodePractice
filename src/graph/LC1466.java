package graph;

import java.util.ArrayList;
import java.util.List;

public class LC1466 {
    public int minReorder(int n, int[][] connections) {
        // Make an adj list
        List<List<Integer>> al = new ArrayList<>();
        boolean[] visited = new boolean[n];
        // Build graph
        for (int i = 0; i < n; ++i) {
            al.add(new ArrayList<>());
        }
        // Build connections
        for (int c[] : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        // dfs from node zero.
        return dfs(al, visited, 0);
    }

    private int dfs(List<List<Integer>> al, boolean[] visited, int u) {
        int res = 0;
        visited[u] = true;
        for (int v : al.get(u)) {
            if (!visited[Math.abs(v)]) {
                res += dfs(al, visited, Math.abs(v)) + (v > 0 ? 1 : 0);
            }
        }
        return res;
    }
}
