package graph;

import java.util.HashMap;
import java.util.Map;

public class LC1791 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int uCount = count.getOrDefault(u, 0) + 1;
            int vCount = count.getOrDefault(v, 0) + 1;
            if (uCount > 1) return u;
            if (vCount > 1) return v;
            count.put(u, uCount);
            count.put(v, vCount);
        }
        return 0;
    }
}
