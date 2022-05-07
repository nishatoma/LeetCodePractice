class PathWithMinimumEffort_1631 {

    public int minimumEffortPath(int[][] heights) {
        int lo = 0, hi = (int) 10e6;
        int n = heights.length, m = heights[0].length;
        
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean visited[][] = new boolean[n][m];
            if (isPossible(heights, visited, 0, 0, heights[0][0], mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return hi;
    }
    
    private boolean isPossible(int[][] hts, boolean[][] visited, int r, int c, int last, int t) {
        int n = hts.length, m = hts[0].length;
        
        if (r >= n ||
           c >= m ||
           r < 0 ||
           c < 0 ||
            visited[r][c] ||
           Math.abs(hts[r][c] - last) > t) {
            return false;
        }
        
        visited[r][c] = true;
        
        return
            ((r == n - 1 &&
            c == m - 1) ||
            isPossible(hts, visited, r + 1, c, hts[r][c], t) ||
            isPossible(hts, visited, r - 1, c, hts[r][c], t) ||
            isPossible(hts, visited, r, c + 1, hts[r][c], t) ||
            isPossible(hts, visited, r, c - 1, hts[r][c], t));
    }
}