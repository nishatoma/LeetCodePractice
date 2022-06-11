package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork_1192 {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = buildGraph(n, connections);
        // Keep track of visiting time
        int[] visitedTime = new int[n];
        // Keep track of lowest time
        int[] lowestTime = new int[n];
        // Keep track of visited nodes
        boolean[] vis = new boolean[n];
        // Keep track of results ArrayList
        List<List<Integer>> res = new ArrayList<>();
        // Start with node 0
        int nodeZero = 0;
        // Parent starts at -1
        int parent = -1;
        // Keep track of time
        int time = 0;
        // Call DFS and traverse the graph
        dfs(graph, visitedTime, lowestTime, vis, res, nodeZero, parent, time);
        return res;
    }

    // Iterate over the graph
    private void dfs(List<Integer>[] graph, int[] visitedTime, int[] lowestTime, boolean[] vis, List<List<Integer>> res, int src, int parent, int time) {
        if (vis[src]) return;
        // Mark node as true
        vis[src] = true;
        // Mark visitedTime and lowestTime
        visitedTime[src] = lowestTime[src] = time++;
        // Now process neighbours
        for (int neighbour : graph[src]) {
            // Nothing to do here
            if (neighbour == parent) continue;
            if (!vis[neighbour]) {
                // DFS over neighbour
                dfs(graph, visitedTime, lowestTime, vis, res, neighbour, src, time);
                // Take care of propagation for other nodes
                lowestTime[src] = Math.min(lowestTime[src], lowestTime[neighbour]);
                if (visitedTime[src] < lowestTime[neighbour]) {
                    res.add(Arrays.asList(src, neighbour));
                }
            } else {
                // Else, we found a back-edge (loop), update lowestTime
                lowestTime[src] = Math.min(lowestTime[src], visitedTime[neighbour]);
            }
        }
    }

    // Build the graph
    private List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        return graph;
    }
}
