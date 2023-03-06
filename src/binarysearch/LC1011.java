package binarysearch;

public class LC1011 {
    public int shipWithinDays(int[] weights, int days) {
        // find max weight of entire array
        int maxWeight = 0;
        int n = weights.length;
        for (int weight : weights) {
            // This is the total weight of all our weights
            maxWeight += weight;
        }
        // We can eitehr use weight of 1 (min) or maxWeight
        // The answer lies somewhere in between.
        int lo = 1, hi = maxWeight;
        // Binary search
        while (lo <= hi) {
            // Get the mid point weight
            int mid = lo + (hi - lo) / 2;
            // Try to to see if we can ship within days
            // using this weight
            boolean canShip = canShipWeightWithinDays(weights, days, mid);
            // If we can, search for lower weight
            if (canShip) {
                hi = mid - 1;
            } else {
                // Otherwise, look to increase the maximum amount of weight
                // we can carry.
                lo = mid + 1;
            }
        }
        // Return the lowest maximum weight we need to use
        return lo;
    }

    private boolean canShipWeightWithinDays(int[] arr, int days, int maxWeight) {
        int sum = 0;
        for (int weight : arr) {
            if (maxWeight >= sum + weight) {
                sum += weight;
            } else {
                --days;
                sum = weight;
            }
            // Check days and current weight
            if (days <= 0 || sum > maxWeight) {
                return false;
            }
        }
        return true;
    }
}
