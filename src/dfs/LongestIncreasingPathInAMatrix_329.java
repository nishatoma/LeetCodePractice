package dfs;

public class LongestIncreasingPathInAMatrix_329 {

    public int longestIncreasingPath(int[][] matrix) {
        int longest = Integer.MIN_VALUE;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                longest = Math.max(longest, getMoves(matrix, i, j, dirs, cache));
            }
        }
        return longest;
    }

    private int getMoves(int[][] matrix, int r, int c, int[] dirs, int[][] cache) {
        if (cache[r][c] > 0) return cache[r][c];
        int longestPath = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < dirs.length - 1; ++i) {
            int x = r + dirs[i];
            int y = c + dirs[i + 1];

            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[r][c]) continue;
            int count = 1 + getMoves(matrix, x, y, dirs, cache);
            longestPath = Math.max(longestPath, count);
        }
        cache[r][c] = longestPath;
        return longestPath;
    }
}
