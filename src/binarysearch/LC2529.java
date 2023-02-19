package binarysearch;

public class LC2529 {
    public int maximumCount(int[] nums) {
        // find the lowest index
        // in which we have a positive number..
        // get the max of lo - 0 and len - lo...
        int len = nums.length;
        // Edge case
        if (nums[0] == 0 && nums[len - 1] == 0) return 0;
        int lo = 0, hi = len;
        int countZeros = 0;
        // Binary search
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // get the middle element
            // if zero count them
            if (nums[mid] == 0) {
                countZeros++;
                // It means we still need to find a bigger index
                // Since we are still looking for a positive #
                lo = mid + 1;
            }
            else if (nums[mid] > 0) {
                // if positive, keep looking left
                // to find lowest index of positive #
                hi = mid;
            } else {
                // Keep looking right
                lo = mid + 1;
            }
        }
        // Get the max of lo - 0 - countZeros and len - lo
        // we can change lo - 0 - countZeros to simply lo - countZeros
        return Math.max(lo - countZeros, len - lo);
    }
}
