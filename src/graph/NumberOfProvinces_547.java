package graph;

public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        // Get the number of cities
        int cities = isConnected.length;
        // Get an array to mark visited nodes
        boolean[] vis = new boolean[cities];
        // Count number of provinces
        int count = 0;
        // Iterate over the cities
        for (int i = 0; i < cities; ++i) {
            // already visited
            if (vis[i]) continue;
            // increment number of provinces
            count++;
            // Mark visited
            vis[i] = true;
            // process rest of the connected nodes
            dfs(i, isConnected, vis);
        }
        // Return number of provinces
        return count;
    }

    // DFS solution
    private void dfs(int src, int[][] isConnected, boolean[] vis) {
        // For each node in the row
        for (int i = 0; i < isConnected[src].length; ++i) {
            // If disconnecte, or src == i, or visited,
            // then skip
            if (vis[i] || src == i || isConnected[src][i] == 0) continue;
            // Mark as visited
            vis[i] = true;
            // Otherwise, process more
            dfs(i, isConnected, vis);
        }
    }
}
