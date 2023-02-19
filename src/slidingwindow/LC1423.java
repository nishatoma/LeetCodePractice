package slidingwindow;

public class LC1423 {
    public int maxScore(int[] cardPoints, int k) {
        // We can change this problem statement, to
        // Find minimum subarray sum of size cardPoints.length - k!!
        // Let's try this.
        // Get the total sum of the cardPoints array
        long totalSum = 0;
        int len = cardPoints.length;
        for (int i = 0; i < len; ++i) {
            totalSum += cardPoints[i];
        }
        // Get length - k, to determine min subarray window size
        int minSubArrayWindow = len - k;
        if (minSubArrayWindow == 0) return (int) totalSum;
        // Otherwise, find the min subarray sum, and subtract it from
        // totalSum to get the maxScore.
        int minSubArraySum = Integer.MAX_VALUE;
        // Get current sum
        long currentSum  = 0;
        // Loop through the array again
        for (int i = 0; i < len; ++i) {
            currentSum += cardPoints[i];
            // See if we reached window size
            if (i >= minSubArrayWindow) {
                // Subtract from the sum to move the window
                currentSum -= cardPoints[i - minSubArrayWindow];
            }
            // If we reached the exact size, then, take the minimum
            if (i >= minSubArrayWindow - 1) {
                minSubArraySum = (int) Math.min(minSubArraySum, currentSum);
            }
        }
        return (int) (totalSum - minSubArraySum);
    }
}
