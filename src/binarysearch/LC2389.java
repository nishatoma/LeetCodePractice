package binarysearch;

import java.util.Arrays;

public class LC2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // prefix
        int[] prefix = new int[nums.length];
        int n = nums.length;
        int m = queries.length;
        prefix[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // get the result array
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            // we will apply binary search
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] <= queries[i]) {
                    // look even further right, maximize window
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            res[i] = lo;
        }
        return res;
    }
}
