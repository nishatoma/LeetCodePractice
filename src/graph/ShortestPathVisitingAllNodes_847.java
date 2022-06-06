package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathVisitingAllNodes_847 {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int endMask = (1 << n) - 1;
        // To mark a node seen
        boolean[][] seen = new boolean[n][endMask];
        // Queue for BFS
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
            seen[i][1 << i] = true;
        }
        // Representing shortest path
        int levels = 0;

        while (!q.isEmpty()) {
            int s = q.size();

            while (s-- != 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int mask = curr[1];

                // Otherwise check neighbors
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    // check if we reached end
                    if (nextMask == endMask) return levels + 1;
                    // if not seen
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        q.offer(new int[]{neighbor, nextMask});
                    }
                }
            }
            levels++;
        }
        return 0;
    }
}
