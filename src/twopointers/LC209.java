package twopointers;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        // Get current sum
        int sum = 0;
        for (int right = 0; right < n; ++right) {
            // Increased the sum
            sum += nums[right];
            // Check whil the condition is true
            while (sum >= target) {
                // Update window size
                if (right - left + 1 < res) {
                    res = right - left + 1;
                }
                // Decrease the sum from the left
                sum -= nums[left++];
            }
        }
        // Edge case
        if (left == 0) {
            return left;
        }
        return res;
    }
}
