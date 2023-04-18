package graph;

import java.util.ArrayList;
import java.util.List;

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> list = new ArrayList<>();
        // Make empty edges first
        for (int i = 0; i <= n; ++i) {
            list.add(new ArrayList<>());
        }

        int[] res = new int[2];
        // build the graph
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dfs(u, v, 0, list)) {
                res = edge;
            } else {
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
        return res;
    }

    private boolean dfs(int u, int v, int pre, List<List<Integer>> al) {
        if (u == v) {
            return true;
        }

        for (int w : al.get(u)) {
            if (w == pre) continue;
            boolean ret = dfs(w, v, u, al);
            if (ret) return true;
        }
        return false;
    }
}
