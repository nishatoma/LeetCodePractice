package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubIslands_1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        // directions from row/col
        int[] dirs = new int[]{1, 0, -1, 0, 1};

        boolean isLand = true;
        int count = 0;

        // Iterate over grid2
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // No need to process
                if (grid2[i][j] == 0) continue;

                // process coordinate
                isLand = true;
                Deque<int[]> q = new ArrayDeque<>();
                q.push(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] coord = q.poll();

                    if (grid1[coord[0]][coord[1]] == 0) isLand = false;

                    // Process all directions now
                    for (int k = 0; k < 4; ++k) {
                        int x = coord[0] + dirs[k];
                        int y = coord[1] + dirs[k + 1];

                        // If the coordinate is a 1 and it's a valid coordinate,
                        // Add it to our queue to explore more possibilities
                        if (x >= 0 && x < n && y >= 0 && y < m && grid2[x][y] == 1) {
                            grid2[x][y] = 0;
                            q.offer(new int[]{x, y});
                        }
                    }
                }

                if (isLand) {
                    count++;
                }
            }
        }
        return count;
    }
}
