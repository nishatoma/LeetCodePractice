package contest;

public class CountSubArraysWithScoreLessThanK_2302 {
    public long countSubarrays(int[] nums, long k) {
        // Variable for result
        long res = 0;
        // Current sum of sub-array
        long sum = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            // Increase sum
            sum += nums[i];
            // If the sum * the size of our sub-array
            // is >= k, then decreased the window
            while (sum * (i - j + 1) >= k) {
                // j++ means making the window
                // smaller from the left side
                // sum -= means decreasing the sum by
                // subtracting the left-most element
                sum -= nums[j++];
            }
            // Add our current window size which represents
            // our subarray size to the final result
            res += (i - j + 1);
        }
        return res;
    }
}
