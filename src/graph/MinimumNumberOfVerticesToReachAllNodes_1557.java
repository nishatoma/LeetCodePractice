package graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] reachable = new boolean[n];
        List<Integer> res = new ArrayList<>();

        for (List<Integer> edge : edges) {
            reachable[edge.get(1)] = true;
        }

        for (int i = 0; i < n; ++i) {
            if (!reachable[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
