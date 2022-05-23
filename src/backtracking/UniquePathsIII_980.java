package backtracking;

public class UniquePathsIII_980 {

    public int uniquePathsIII(int[][] grid) {
        // Count the number of zeros
        int zeros = 0;
        // Starting row and col
        int startX = 0, startY = 0;
        // Iterate through the grid
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // find the starting pos
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    continue;
                }
                // Count number of zeros
                if (grid[i][j] == 0) zeros++;
            }
        }

        return dfs(grid, startX, startY, zeros);
    }

    private int dfs(int[][] grid, int x, int y, int zeros) {
        // base case
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) return 0;

        // found the ending
        if (grid[x][y] == 2) {
            return zeros == -1 ? 1 : 0;
        }

        // mark as visited
        grid[x][y] = -1;
        // DFS over remaining paths
        int res = dfs(grid, x + 1, y, zeros - 1) +
                dfs(grid, x, y + 1, zeros - 1) +
                dfs(grid, x - 1, y, zeros - 1) +
                dfs(grid, x, y - 1, zeros - 1);
        // unmark
        grid[x][y] = 0;

        return res;

    }
}
