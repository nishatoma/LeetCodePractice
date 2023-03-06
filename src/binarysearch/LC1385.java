package binarysearch;

import java.util.Arrays;

public class LC1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Make array 1 the smallest
        int m = arr1.length, n = arr2.length;
        // Sort array 2
        Arrays.sort(arr2);
        // Make a result counter
        int res = 0;
        // For each element in arr 1, find distance
        for (int i = 0; i < m; ++i) {
            if (isDistanceGreaterThanD(arr1[i], arr2, d)) {
                ++res;
            }
        }
        return res;
    }

    private boolean isDistanceGreaterThanD(int num, int[] arr2, int d) {
        // Assume arr2 is sorted in this case
        int lo = 0, hi = arr2.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // check distance
            if (Math.abs(num - arr2[mid]) <= d) {
                return false;
            } else if (num > arr2[mid]) {
                lo = mid + 1; // Otherwise, check if current element is bigger than middle element
            } else {
                hi = mid - 1;
            }
        }
        // Return true in the end
        return true;
    }
}
