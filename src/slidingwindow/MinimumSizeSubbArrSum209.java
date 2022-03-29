package slidingwindow;

public class MinimumSizeSubbArrSum209 {

    public int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; ++r) {
            sum += nums[r];

            // Check if the sum is >= target
            while (l < nums.length && sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }
}
