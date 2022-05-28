package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // BFS Approach
        List<List<Integer>> res = new ArrayList<>();

        // Make a queue to process each path
        Deque<List<Integer>> q = new ArrayDeque<>();

        // Make a list for current path
        List<Integer> path = new ArrayList<>();
        // Add first node
        path.add(0);
        // Add first path to queue
        q.add(path);
        // Go through all paths in the queue
        while (!q.isEmpty()) {
            // Get current path
            List<Integer> currPath = q.poll();
            // Get last node
            int node = currPath.get(currPath.size() - 1);
            // If it's equal to the node we are looking for
            if (node == graph.length - 1) {
                // we found the path
                res.add(currPath);
                // Process next node
                continue;
            }
            // go through each neighbor
            for (int neighbor : graph[node]) {
                // Establish a new path from each neighbor
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(neighbor);
                // Add the new path to the queue
                q.add(newPath);
            }
        }
        return res;
    }
}
