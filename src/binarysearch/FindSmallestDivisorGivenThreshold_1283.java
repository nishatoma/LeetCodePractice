package binarysearch;

public class FindSmallestDivisorGivenThreshold_1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = max(nums);

        if (threshold == nums.length) return hi;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (canDivide(nums, threshold, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canDivide(int[] nums, int t, int divisor) {
        int sum = 0;

        for (double num : nums) {
            sum += (num + divisor - 1) / divisor;

            if (sum > t) return false;
        }

        return true;
    }

    private int max(int[] nums) {
        int max = 1;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
