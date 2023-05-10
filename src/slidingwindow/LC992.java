package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Basically, use the standard format for sliding window
        // but realize that if we get atMost K window, and subtract
        // with atMost k -1, we can get the exact number of subarrays!!
        return getAtMostKSubArrays(nums, k) - getAtMostKSubArrays(nums, k - 1);
    }

    private int getAtMostKSubArrays(int[] A, int K) {
        int left = 0;
        int res = 0;
        // Keep count
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < A.length; ++right) {
            if (map.getOrDefault(A[right], 0) == 0) {
                --K;
            }
            // Increement count
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);

            // If K < 0, decrease window by resetting/ or removing values from
            // the left side of the window
            while (K < 0) {
                map.put(A[left], map.getOrDefault(A[left], 0) - 1);
                // If we reached zero, it would be as if we never added that
                // element to the map, so, just increment K!
                if (map.get(A[left]) == 0) {
                    ++K;
                }
                ++left;
            }
            // Increment result
            res += right - left + 1;
        }
        return res;
    }
}
