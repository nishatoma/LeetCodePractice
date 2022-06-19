package twopointers;

import java.util.Arrays;

public class RangeSumSortedSubArraySums_1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) (1e9 + 7);
        // We can use pre-fix sum to build
        // our answer space for sub-array sums
        int[] preSums = new int[n + 1];
        preSums[0] = 0;
        // build up our pre-fix array
        for (int i = 0; i < n; ++i) {
            // for example, nums = [1, 2, 3, 4] => preSums = [0, 1, 3, 6, 10]
            preSums[i + 1] = preSums[i] + nums[i];
        }
        // Then build up our sub-arrays sums array using pre-fix sums
        int[] subSums = new int[n * (n + 1) / 2];
        // Use two pointers to iterate over our pre-fix sums
        // and build the array
        int idx = 0;
        for (int i = 0; i < preSums.length; ++i) {
            // Iterate from right
            for (int j = preSums.length - 1; j > i; --j) {
                subSums[idx++] = preSums[j] - preSums[i];
            }
        }
        // Now sort the sub-sums array
        Arrays.sort(subSums);
        // Now take left and right boundaries and sum them
        long res = 0;
        for (int i = left - 1; i < right; ++i) {
            res = (res + subSums[i]) % mod;
        }
        return (int) res;
    }
}
