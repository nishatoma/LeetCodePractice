package binarysearch;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum_2389 {

    public int[] answerQueries(int[] nums, int[] qs) {
        // Sort input array
        Arrays.sort(nums);
        // Get Ans array
        int[] ans = new int[qs.length];
        // Construct prefix sum
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        // Find index for each query
        int i = 0;
        for (int q : qs) {
            ans[i++] = findNum(nums, q);
        }

        return ans;
    }

    int findNum(int[] nums, int q) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] + nums[lo] > q) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo + 1;
    }
}
