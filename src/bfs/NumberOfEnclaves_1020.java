package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves_1020 {

    public int numEnclaves(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 1) {
                    destroyBadIslands(grid, i, j);
                }
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    private void destroyBadIslands(int[][] grid, int r, int c) {
        int[] dirs = new int[]{1, 0, -1, 0, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});


        while (!q.isEmpty()) {
            int[] curr = q.poll();
            // Mark visited
            grid[curr[0]][curr[1]] = -1;

            for (int i = 0; i < dirs.length - 1; ++i) {
                int x = curr[0] + dirs[i];
                int y = curr[1] + dirs[i + 1];

                // If invalid
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                    continue;
                }

                // Otherwise, if it's also a 1, keep going
                if (grid[x][y] == 1) {
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
