package topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParallelCoursesIII_2050 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        // Array to calculate indegree
        int[] indegree = new int[n];
        // Build a graph
        List<Integer>[] graph = buildGraph(n, relations, indegree);
        // Get a Queue for BFS
        Deque<Integer> q = new ArrayDeque<>();
        // Keep track of completion time for courses so far
        int[] timeSoFar = new int[n];
        // For each node with indegree 0, add to queue to explore first
        for (int i = 0; i < n; ++i) {
            // Offer the course with no pre-reqs
            if (indegree[i] == 0) {
                q.offer(i);
                timeSoFar[i] = time[i];
            }
        }
        // Keep global max
        int res = 0;
        // Iterate over each beginner course
        while (!q.isEmpty()) {
            int u = q.poll();
            // For neighbours
            for (int v : graph[u]) {
                timeSoFar[v] = Math.max(timeSoFar[v], timeSoFar[u] + time[v]);
                // Then see if pre-reqs are finished
                if (--indegree[v] == 0) {
                    // Then add v to q
                    q.offer(v);
                }
            }
        }
        // Find global max
        for (int t : timeSoFar) res = Math.max(res, t);
        return res;
    }

    // Build a graph
    private List<Integer>[] buildGraph(int n, int[][] relations, int[] indegree) {
        List<Integer>[] graph = new ArrayList[n];
        // for each node
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        // For each relation
        for (int[] relation : relations) {
            graph[relation[0] - 1].add(relation[1] - 1);
            // claculate indegree
            indegree[relation[1] - 1]++;
        }
        return graph;
    }
}
