package graph;

import java.util.ArrayList;
import java.util.List;

public class LC1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // Since we have a DAG, we can safely assume that
        // our nodes with 0 in-degree (no nodes coming to them) MUST be
        // part of our solution set.
        // Make an array for our nodes and calculate their indegree
        int[] indegree = new int[n];
        // For each edge, save the second element
        // with its indegree incremented.
        for (List<Integer> edge : edges) {
            // Save indegree
            indegree[edge.get(1)]++;
        }
        // go over the indegrees now
        // whichever has a zero, add to result set
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
