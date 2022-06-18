package twopointers;

import java.util.Arrays;

public class FindDistanceValueBetweenTwoArrays_1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Sort any of the arrays
        Arrays.sort(arr2);
        // Create count variable for result
        int res = 0;
        // Go through each number from first Array
        for (int num : arr1) {
            if (isGreater(arr2, num, d)) res++;
        }
        return res;
    }

    // Search for a number that matches the question criteria
    private boolean isGreater(int[] arr, int num, int d) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (getDist(arr[mid], num) <= d) {
                return false;
            } else if (arr[mid] >= num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return true;
    }

    // Make a method to find the distance between two points
    private int getDist(int n1, int n2) {
        return Math.abs(n1 - n2);
    }
}
