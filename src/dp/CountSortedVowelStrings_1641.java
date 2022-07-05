package dp;

public class CountSortedVowelStrings_1641 {

    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < 6; ++j) {
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 3; j >= 0; j--) {
                dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
            }
        }

        return dp[n][0];
    }
}
