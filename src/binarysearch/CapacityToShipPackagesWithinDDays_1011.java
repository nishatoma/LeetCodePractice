package binarysearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays_1011 {

    public int shipWithinDays(int[] weights, int days) {

        int lo = 1;
        int hi = Arrays.stream(weights).sum();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canShip(weights, mid, days)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static boolean canShip(int[] wts, int capacity, int D) {
        int w = 0, d = 1;

        for (int wt : wts) {
            if (wt > capacity || d > D) return false;

            if (w + wt > capacity) {
                w = wt;
                d++;
            } else {
                w += wt;
            }
        }

        return d <= D;
    }
}
