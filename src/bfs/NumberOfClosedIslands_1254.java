package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfClosedIslands_1254 {

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0 && isClosedIsland(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isClosedIsland(int[][] grid, int r, int c) {
        // To explore more directions
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        // Queue for BFS
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        // Boolean
        boolean closed = true;
        while (!q.isEmpty()) {
            // Get current coordinate
            int[] curr = q.poll();
            // Mark as 'visited'
            grid[curr[0]][curr[1]] = 1;
            // Check all directions
            for (int i = 0; i < dirs.length - 1; ++i) {
                int x = curr[0] + dirs[i];
                int y = curr[1] + dirs[i + 1];
                // If invalid cooridnates
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                    closed = false;
                    continue;
                }
                // We found more land
                if (grid[x][y] == 0) {
                    q.offer(new int[]{x, y});
                }
            }
        }
        return closed;
    }
}
