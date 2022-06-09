package graph;

import java.util.ArrayList;
import java.util.List;

public class MaximumPathQualityOfAGraph_2065 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < values.length; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] vis = new int[values.length];

        dfs(values, adjList, vis, 0, maxTime, 0, 0);

        return ans;
    }

    int ans = -1;

    // O(4^10) since there are maximum 10 nodes in a valid path, and each node has a maximum
    // of 4 edges connected to it
    private void dfs(int[] values, List<List<int[]>> adj, int[] vis, int src, int maxTime, int currTime, int score) {
        if (currTime > maxTime) return;

        if (vis[src] == 0) score += values[src];

        // Get answer when we get 0
        if (src == 0) ans = Math.max(ans, score);

        // Mark visited
        vis[src]++;

        for (int[] v : adj.get(src)) {
            dfs(values, adj, vis, v[0], maxTime, v[1] + currTime, score);
        }

        // Unmark
        vis[src]--;
    }
}
