package graph;

public class LC547 {
    public int findCircleNum(int[][] isConnected) {
        // Idea is to keep track of nodes we have visited
        // when we encounter a node we have no visited
        // and it's connected, we simply increase the result..
        int res = 0;
        int[] vis = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; ++i) {
            if (vis[i] == 0) {
                dfs(isConnected, i, vis);
                res++;
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int node, int[] visited) {
        for (int i = 0; i < grid.length; ++i) {
            if (grid[node][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(grid, i, visited);
            }
        }
    }
}
