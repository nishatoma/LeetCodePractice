package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn_947 {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowAdj = new HashMap<>();
        Map<Integer, List<Integer>> colAdj = new HashMap<>();

        boolean[] vis = new boolean[stones.length];

        for (int i = 0; i < stones.length; ++i) {
            rowAdj.computeIfAbsent(stones[i][0], k -> new ArrayList<>()).add(i);
            colAdj.computeIfAbsent(stones[i][1], k -> new ArrayList<>()).add(i);
        }

        int numEdges = 0;
        for (int i = 0; i < stones.length; ++i) {
            if (!vis[i]) {
                getEdges(rowAdj, colAdj, stones, vis, i);
                numEdges++;
            }

        }

        return stones.length - numEdges;
    }

    private int getEdges(Map<Integer, List<Integer>> rowAdj, Map<Integer, List<Integer>> colAdj, int[][] stones, boolean[] vis, int stone) {
        if (vis[stone]) return 0;
        int r = stones[stone][0];
        int c = stones[stone][1];
        vis[stone] = true;
        // For each stone find how many neighbors we have, and if we make it to the end we return 1
        // because we can find 1 unvisited edge per call
        for (int stn : rowAdj.get(r)) {
            getEdges(rowAdj, colAdj, stones, vis, stn);
        }

        // Same thing for column neighbors
        for (int stn : colAdj.get(c)) {
            getEdges(rowAdj, colAdj, stones, vis, stn);
        }
        return 1;
    }
}
