package dp;

public class PartitionArrayForMaximumSum_1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[K];

        for (int i = 0; i <= N; ++i) {
            int currMax = 0;
            int best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                currMax = Math.max(currMax, A[i - k]);
                best = Math.max(best, dp[(i - k) % K] + currMax * k);
            }
            dp[i % K] = best;
        }
        return dp[N % K];
    }
}
