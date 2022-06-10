package graph;

public class MaximalNetworkRank_1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        // Mark matrix for connected nodes
        int[][] adj = new int[n][n];
        // count freq of each node
        int[] freqs = new int[n];
        // Go over the nodes
        for (int[] road : roads) {
            freqs[road[0]]++;
            freqs[road[1]]++;
            adj[road[0]][road[1]] = 1;
            adj[road[1]][road[0]] = 1;
        }
        // Now go over each pair, and calculate the result
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (i == j) continue;

                res = Math.max(res, freqs[i] + freqs[j] - adj[i][j]);
            }
        }
        return res;
    }
}
