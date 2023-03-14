package graph;

import java.util.PriorityQueue;

public class LC1584 {
    public int minCostConnectPoints(int[][] points) {
        // Since we are trying to minimize the cost,
        // We can use MST (Minimum Spanning Tree) using
        // a heap (Prim's) algorithm.
        // Construct a min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        // Initialize result
        int res = 0;
        // Starting node
        int i = 0;
        // Number of connected nodes
        int connected = 0;
        // Number of total nodes
        int n = points.length;
        // keep track of visited nodes
        boolean[] visited = new boolean[n];
        // While we still don't have all the nodes connected
        while (++connected < n) {
            // Mark as visited
            visited[i] = true;
            // For each child node
            for (int j = 1; j < n; ++j) {
                // check if visited
                if (visited[j]) {
                    continue;
                }
                // Otherwise, add the manhattan distance to PQ
                pq.offer(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), j});
            }
            // Check if already visited, then we don't need to process this distance anymore
            while (visited[pq.peek()[1]]) {
                // poll
                pq.poll();
            }
            // Otherwise, add the manhattan distance to the result
            res += pq.peek()[0];
            // Assign i to the next node to process
            i = pq.poll()[1];
        }

        return res;
    }
}
