package binarysearch;

import java.util.Arrays;

public class LC2517 {
    public int maximumTastiness(int[] prices, int k) {
        // Idea is to sory array first
        Arrays.sort(prices);
        // Our smallest range difference is zero
        int lo = 0;
        // Our largest is just max - min
        int n = prices.length;
        int hi = prices[n - 1] - prices[0];
        // Now biary search
        while (lo <= hi) {
            // Get the mid point difference
            int mid = lo + (hi - lo) / 2;
            // Compare and see if we can
            // find K pairs that are >= mid
            if (isPossible(prices, mid, k)) {
                // If that's the case, try a bigger difference
                // between prices
                lo = mid + 1;
            } else {
                // Otherwise, try a smaller difference
                hi = mid - 1;
            }
        }
        // Return lo in the end
        return hi;
    }

    private boolean isPossible(int[] arr, int mid, int k) {
        // Get a count variable to count
        // number of elements that make up the basket
        int count = 1;
        // Get the previous element in the basket, start from smallest
        // element in the array.
        int prev = arr[0];
        // Iterate through rest of the array
        for (int i = 1; i < arr.length; ++i) {
            // Compare the difference between the two
            if (arr[i] - prev >= mid) {
                // Then we can include in the basket, so
                // set this element as the new previous
                prev = arr[i];
                // increase the count
                if (++count == k) {
                    return true;
                }
            }
        }
        // We never found the amount of pairs we need to form the basket
        return false;
    }
}
