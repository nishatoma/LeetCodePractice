package backtracking;

public class PathWithMaximumGold_1219 {

    public int getMaximumGold(int[][] grid) {
        // Initialize result variable
        int res = 0;

        // Loop over entire matrix, and for each
        // element, find it's possible gold count
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != 0) {
                    // Update the global maxima whenever
                    // we find a new count
                    res = Math.max(res, dfs(grid, i, j, 0));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int r, int c, int curr) {
        int res = 0;

        // If we have invalid coordinates, or we encounter a zero, just return the current count
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0) return curr;

        // Store current value
        int temp = grid[r][c];
        // Increased the current amount
        curr += temp;
        // Set the grid value as zero, meaning we visited this
        // cell
        grid[r][c] = 0;
        // do the same for all directions
        res = Math.max(dfs(grid, r, c + 1, curr), res);
        res = Math.max(dfs(grid, r + 1, c, curr), res);
        res = Math.max(dfs(grid, r - 1, c, curr), res);
        res = Math.max(dfs(grid, r, c - 1, curr), res);
        // backtrack
        grid[r][c] = temp;

        return res;
    }
}
