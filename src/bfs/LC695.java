package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int rows = grid.length, cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(grid, i, j, dirs));
                }
            }
        }
        return ans;
    }

    int bfs(int[][] grid, int row, int col, int[] dirs) {
        int ans = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        grid[row][col] = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            ++ans;
            for (int i = 0; i < dirs.length - 1; ++i) {
                int dx = top[0] + dirs[i];
                int dy = top[1] + dirs[i + 1];
                if (dx < 0 || dy < 0 || dx > grid.length - 1 || dy > grid[0].length - 1 || grid[dx][dy] == 0) continue;
                // Add to queue
                q.offer(new int[]{dx, dy});
                // Set to zero.
                grid[dx][dy] = 0;
            }
        }
        return ans;
    }
}
