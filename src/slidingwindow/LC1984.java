package slidingwindow;

import java.util.Arrays;

public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = k - 1; i < nums.length; ++i) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }
        return res;
    }
}
