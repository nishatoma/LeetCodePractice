package dp;

public class CherryPickUp_1463 {

    public int cherryPickup(int[][] grid) {
        int[] dirs = new int[]{-1, 0, 1};
        // Get rows and cols
        int rows = grid.length;
        int cols = grid[0].length;
        // DP table
        int[][][] dp = new int[rows][cols][cols];

        // Initialize
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                for (int k = 0; k < cols; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // First robot
        int col1 = 0;
        // Second robot
        int col2 = cols - 1;
        // Init dp table
        dp[0][col1][col2] = grid[0][col1] + grid[0][col2];
        int max = dp[0][col1][col2];
        // iterate
        for (int i = 1; i < rows; ++i) {
            // Get every column for both robots
            for (int c1 = 0; c1 < cols; ++c1) {
                // For second robot
                for (int c2 = 0; c2 < cols; ++c2) {
                    int prev = dp[i - 1][c1][c2];
                    // Only look at positive values
                    if (prev >= 0) {
                        // Get next directions
                        for (int d1 : dirs) {
                            col1 = d1 + c1;
                            // Get next directions for robot 2
                            for (int d2 : dirs) {
                                col2 = d2 + c2;
                                // Update DP table
                                if (inRange(col1, cols) && inRange(col2, cols)) {
                                    dp[i][col1][col2] = Math.max(dp[i][col1][col2], prev + (col1 == col2 ? grid[i][col1] : grid[i][col1] + grid[i][col2]));
                                    max = Math.max(max, dp[i][col1][col2]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    private boolean inRange(int val, int limit) {
        return 0 <= val && val < limit;
    }
}
