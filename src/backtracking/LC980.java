package backtracking;

public class LC980 {
    public int uniquePathsIII(int[][] grid) {
        // Find total # of zeros
        // Find starting position
        // DFS from there
        int m = grid.length, n = grid[0].length;
        int numZeros = 0;
        int startingX = 0, startingY = 0;
        // Iterate
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) ++numZeros;
                else if (grid[i][j] == 1) {
                    startingX = i;
                    startingY = j;
                }
            }
        }
        return dfs(grid, startingX, startingY, numZeros);
    }

    private int dfs(int[][] grid, int i, int j, int numZeros) {
        if (shouldNotProcess(grid, i, j)) {
            return 0;
        }

        // if we encounter a 2, check the numOfZeros..
        if (grid[i][j] == 2) {
            return numZeros < 0 ? 1 : 0;
        }

        // Decrease number of zeros
        --numZeros;
        // Mark as visited
        grid[i][j] = -1;
        // DFS the rest
        int totalPaths = dfs(grid, i + 1, j, numZeros) +
            dfs(grid, i, j + 1, numZeros) +
            dfs(grid, i - 1, j, numZeros) +
            dfs(grid, i, j - 1, numZeros);
        // Unmark
        grid[i][j] = 0;
        return totalPaths;
    }

    private boolean shouldNotProcess(int[][] grid, int i, int j) {
        return (i < 0 || j < 0 || grid.length <= i || grid[0].length <= j || grid[i][j] == -1);
    }
}
