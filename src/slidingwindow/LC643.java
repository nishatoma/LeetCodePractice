package slidingwindow;

public class LC643 {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        // iterate
        // maintain sum
        double sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            // Check if we crossed boundary
            if (i - k >= 0) {
                sum -= nums[i - k];
            }
            // Take the average here
            if (i + 1 - k >= 0) {
                res = Math.max(res, sum / k);
            }
        }
        return res;
    }
}
