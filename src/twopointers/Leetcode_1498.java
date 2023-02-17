package twopointers;

import java.util.Arrays;

public class Leetcode_1498 {
    public int numSubseq(int[] nums, int target) {
        // The idea, is to sort the array
        // Then, the # of subsequences of a range
        // of size r - l is simply 2^(r-l)...
        // Sort the array first
        Arrays.sort(nums);
        // Get our mod
        int mod = (int) 1e9 + 7;
        int len = nums.length, left = 0, right = len - 1, res = 0;
        // Store the # of subsequences
        int[] pows = new int[len];
        // The subsequence with size 0 is just 1
        pows[0] = 1;
        // Iterate over the rest
        for (int i = 1; i < len; ++i) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        // Iterate just like 2Sum
        while (left <= right) {
            // Get the sum
            int sum = nums[left] + nums[right];
            // Compare to target
            if (sum > target) {
                --right;
            } else {
                res = (res + pows[right - left++]) % mod;
            }
        }
        return res;
    }
}
