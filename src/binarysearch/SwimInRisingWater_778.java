class SwimInRisingWater_778 {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = 0, hi = n*n - 1;
        
        boolean[][] visited = new boolean[n][n];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (dfs(grid, 0, 0, mid, visited)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    static boolean dfs(int[][] grid, int r, int c, int e, boolean[][] visited) {
        
        if (r < 0 || r > grid.length - 1
           || c < 0 || c > grid.length - 1
           || visited[r][c]
           || grid[r][c] > e) return false;
        
        visited[r][c] = true;
        
        return dfs(grid, r + 1, c, e, visited)
            || dfs(grid, r, c + 1, e, visited)
            || dfs(grid, r, c - 1, e, visited)
            || dfs(grid, r - 1, c, e, visited);
    }
}