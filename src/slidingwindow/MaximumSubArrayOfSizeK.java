package slidingwindow;

public class MaximumSubArrayOfSizeK {

    // Find the sub-array of size K, with the biggest sum.
    public static int maxSubArray(int[] arr, int k) {

        int res = 0;


        // Get the first k elements
        for (int i = 0; i < k; i++) {
            res += arr[i];
        }

        // Get the rest of the elements
        // We slide the window by subtracting the first element of the previous window
        // and add the current element to it.
        int currSum = 0;

        for (int i =k ;i < arr.length; i++) {
            currSum += (arr[i] - arr[i - k]);
            res = Math.max(currSum, res);
        }

        // Finally, return the result.
        return res;
    }
}
