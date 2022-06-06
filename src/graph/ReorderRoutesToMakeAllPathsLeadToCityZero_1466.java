package graph;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToCityZero_1466 {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        // Intitialize each array list
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        // Construct the graph
        for (int[] c : connections) {
            // Add outgoing
            adjList.get(c[0]).add(c[1]);
            // Add incoming, represent as -
            adjList.get(c[1]).add(-c[0]);
        }
        // start from node zero
        return dfs(0, adjList, new boolean[n]);
    }

    // process all needed direction changes of neighbors given
    // its node
    private int dfs(int source, List<List<Integer>> adjList, boolean[] vis) {
        int count = 0;
        // Mark node as visited
        vis[source] = true;
        // For each neighbor
        for (int dest : adjList.get(source)) {
            if (!vis[Math.abs(dest)]) {
                count += dfs(Math.abs(dest), adjList, vis) + (dest > 0 ? 1 : 0);
            }
        }
        return count;
    }
}
