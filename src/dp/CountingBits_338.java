package dp;

public class CountingBits_338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; ++i) {
            if (i % 2 == 0) {
                // For even numbers we get the last even number
                // by dividing in half
                dp[i] = dp[i / 2];
            } else {
                // Otherwise, get the last number + 1
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
