package graph;

import java.util.ArrayList;
import java.util.List;

public class LC2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        // Make a graph representation
        List<List<Integer>> graph = new ArrayList<>();
        // Fill the graph with new array lists
        for (int i = 0; i <= roads.length; ++i) {
            graph.add(new ArrayList<>());
        }
        // For each road, build the graph
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            // and vice versa
            graph.get(road[1]).add(road[0]);
        }
        // Get an ans array to keep state in the recursion
        long[] ans = new long[]{0};
        // Now that we have build the graph, DFS
        dfs(0, 0, graph, seats, ans);
        return ans[0];
    }

    private long dfs(int node, int prev, List<List<Integer>> graph, int seats, long[] ans) {
        // Initialize current number of people to 1
        int people = 1;
        // Iterate over the children
        for (int child : graph.get(node)) {
            if (child == prev) {
                // move on
                continue;
            }
            // Otherwise, add to number of people
            people += dfs(child, node, graph, seats, ans);
        }
        // if the current node is not zero, include it in the calculation
        if (node != 0) {
            // To take ceiling of x /y -> (x + y - 1) / y;
            ans[0] += (people + seats - 1) / seats;
        }
        // Return total number of people so far
        return people;
    }
}
