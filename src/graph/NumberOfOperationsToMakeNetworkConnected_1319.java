package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected_1319 {

    public int makeConnected(int n, int[][] connections) {
        // Check first if # of edges is less than # of vertices - 1
        if (connections.length < n - 1) return -1;
        // Our answer is the number of connections - 1, because we need
        // to have n edges connecting (n + 1 vertices)
        int edges = 0;
        // make an adj list
        List<List<Integer>> graph = new ArrayList<>();
        // Init with empty lists
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        // for each connection, construct the graph
        for (int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i){
            edges += dfs(graph, vis, i);
        }
        // Time complexity = O(m + n)
        // where m is the number of connections and n is the number of computers.
        return edges - 1;
    }
    // Time complexity to visit all nodes = O(n)
    private int dfs(List<List<Integer>> graph, boolean[] vis, int node) {
        if (vis[node]) return 0;
        vis[node] = true;
        for (int v : graph.get(node)) {
            dfs(graph, vis, v);
        }
        return 1;
    }
}
