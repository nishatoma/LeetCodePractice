class SwimInRisingWater_778 {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = grid[0][0], hi = n*n - 1;
                    
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean[][] visited = new boolean[n][n];
            if (dfs(grid, 0, 0, mid, visited)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    static boolean dfs(int[][] grid, int r, int c, int e, boolean[][] visited) {
        int n = grid.length;
        
        if (r < 0 || r >= n
           || c < 0 || c >= n
           || visited[r][c]
           || grid[r][c] > e) return false;
        
        visited[r][c] = true;
        
        if (r == n - 1 && c == n - 1) return true;
        
        
        return dfs(grid, r - 1, c,     e, visited)
            || dfs(grid, r + 1, c,     e, visited)
            || dfs(grid, r    , c - 1, e, visited)
            || dfs(grid, r    , c + 1, e, visited);
    }
}