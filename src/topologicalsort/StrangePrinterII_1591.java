package topologicalsort;

import java.util.*;

public class StrangePrinterII_1591 {

    public boolean isPrintable(int[][] grid) {
        Set<Integer> colors = new HashSet<>();
        // Go over the target grid and construct the list of colors
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                colors.add(grid[i][j]);
            }
        }
        // Initialize the graph
        List<Integer>[] graph = new ArrayList[61];
        // Put empty array lists
        for (int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
        }
        // Seen set to track visited colors
        Set<Integer> seen = new HashSet<>();
        // indegree of a 'color'
        int[] indegree = new int[61];
        // Build the graph
        for (int c : colors) {
            makeGraph(grid, c, graph, indegree);
        }
        // Check which colors have no dependency and put them in Queue
        Deque<Integer> q = new ArrayDeque<>();
        for (int c : colors) {
            if (indegree[c] == 0) q.offer(c);
        }
        // BFS now
        while (!q.isEmpty()) {
            int u = q.poll();
            // if seen
            if (!seen.add(u)) continue;
            // Iterate over children
            for (int v : graph[u]) {
                if (--indegree[v] == 0) q.offer(v);
            }
        }
        return seen.size() == colors.size();
    }

    // Sees which color contains which other color
    private void makeGraph(int[][] grid, int color, List<Integer>[] graph, int[] indegree) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        // Comput the boundaries of a color
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == color) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        // If we didn't make that color, just return and proceed with the next color
        if (minX == Integer.MAX_VALUE) return;
        // Now build the graph here
        for (int i = minX; i <= maxX; ++i) {
            for (int j = minY; j <= maxY; ++j) {
                // if we encounter a color different here, it is within the bounds of our first color
                // which makes it a dependency!
                if (grid[i][j] != color) {
                    // Make the graph at that color point to its neighbours
                    graph[grid[i][j]].add(color);
                    indegree[color]++;
                }
            }
        }
    }
}
