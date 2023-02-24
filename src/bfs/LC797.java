package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Make a result variable
        List<List<Integer>> allPaths = new ArrayList<>();
        // Queue for BFS and processing each path...
        Deque<List<Integer>> q = new ArrayDeque<>();
        // Make the first path to explore
        List<Integer> start = new ArrayList<>();
        start.add(0);
        // Add to queue to explore first
        q.offer(start);
        // Explore
        while (!q.isEmpty()) {
            // Get queue size?
            int size = q.size();
            // While size is not empty
            while (size-- != 0) {
                // Pop current llist
                List<Integer> curr = q.poll();
                // check if the vertex matches last node
                int v = curr.get(curr.size() - 1);
                // Check v
                if (v == graph.length - 1) {
                    // then add to current result
                    // and continue
                    allPaths.add(curr);
                    continue;
                }

                // Otherwise, for each neighbour
                for (int neighbour : graph[v]) {
                    // Make a temp list
                    // List<Integer> temp = new ArrayList<>(curr);
                    // temp.add(neighbour);
                    // q.add(temp);
                    // Instead of doing above^, we can just update current
                    curr.add(neighbour);
                    // Then add to queue
                    q.offer(new ArrayList<>(curr));
                    // Then return curr to its original state
                    curr.remove(curr.size() - 1);
                }
            }
        }
        return allPaths;
    }
}
