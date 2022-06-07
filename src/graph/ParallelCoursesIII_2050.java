package graph;

import java.util.*;

public class ParallelCoursesIII_2050 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        // For calculating indegree of a destination node
        // i.e how many pre-reqs does a course have
        int[] indegree = new int[n];
        // Make an adjanceny list to represent the graph
        List<Integer>[] graph = new ArrayList[n];
        // Initiate with empty lists
        Arrays.setAll(graph, e -> new ArrayList<>());
        // Mark elapsed time for a specific node
        int[] elapsed = new int[n];
        // For each relation
        for (int[] rel : relations) {
            // Src and dest
            int src = rel[0] - 1;
            int dst = rel[1] - 1;
            // Count indegree of dst node to see how many
            // pre-reqs it has
            indegree[dst]++;
            // Add both src and dst to graph
            graph[src].add(dst);
        }

        // Queue for BFS
        Deque<Integer> q = new ArrayDeque<>();

        // Find all nodes with in-degree 0 and add them to Q
        // and mark their elapsed time
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                // Then we have a course with no pre-reqs
                q.offer(i);
                elapsed[i] += time[i];
            }
        }
        // max time in total
        int res = 0;
        // Iterate over all nodes
        while (!q.isEmpty()) {
            // Current node
            int node = q.poll();
            // Update res
            res = Math.max(res, elapsed[node]);
            // For each neighbor/child
            for (int child : graph[node]) {
                // Make next course elapsed time either it's current
                // or it's pre-req max
                elapsed[child] = Math.max(elapsed[child], elapsed[node]);
                // Check if we completed all pre-reqs
                if (--indegree[child] == 0) {
                    q.offer(child);
                    // Elapsed time so far is the cost of the
                    // final course + all elapsed time of courses before it
                    elapsed[child] += time[child];
                }
            }
        }

        return res;
    }
}
