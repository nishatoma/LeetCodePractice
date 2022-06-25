package heap;

import java.util.PriorityQueue;

public class SwimInRisingWater_778 {
    public int swimInWater(int[][] grid) {
        // nxn
        int n = grid.length;
        // Min queue to keep track minimum water level
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        // level result
        int level = 0;
        // different directions we can travel
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        // visited boolean
        boolean[][] visited = new boolean[n][n];
        // Add first level at t = 0
        pq.add(new int[]{0, 0});
        // While the queue is not empty
        while (!pq.isEmpty()) {
            int[] coord = pq.poll();
            // pick max of lowest level
            level = Math.max(level, grid[coord[0]][coord[1]]);
            // if we reached the end, break
            if (coord[0] == n - 1 && coord[1] == n - 1) break;
            // for all the directions
            for (int i = 0; i < dirs.length - 1; ++i) {
                // Get the next coordinate
                int x = coord[0] + dirs[i];
                int y = coord[1] + dirs[i + 1];
                // if the coordinate is valid and not visited
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    // then add to pq and visited
                    visited[x][y] = true;
                    pq.offer(new int[]{x, y});
                }
            }
        }
        return level;
    }
}
