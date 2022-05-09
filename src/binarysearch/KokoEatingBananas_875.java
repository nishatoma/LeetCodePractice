package binarysearch;

public class KokoEatingBananas_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = max(piles);

        if (h == piles.length) return hi;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (canEatAll(piles, h, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canEatAll(int[] piles, int h, int bPerHour) {
        int hours = 0;
        for (double bananas : piles) {
            hours += Math.ceil(bananas / bPerHour);

            if (hours > h) return false;
        }

        return true;
    }

    private int max(int[] piles) {
        int max = 1;

        for (int num : piles) {
            max = Math.max(num, max);
        }

        return max;
    }
}
