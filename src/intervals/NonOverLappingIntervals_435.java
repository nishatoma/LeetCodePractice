package intervals;

import java.util.Arrays;

public class NonOverLappingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals by end time
        // O(NLogN)
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // Get count variable
        int count = 0;
        // Get first interval end time
        int end = intervals[0][1];
        // Loop over the rest
        // O(N)
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < end) {
                // Overlap, "remove"
                count++;
            } else {
                // Otherwise, assign the end variable
                // to the next interval
                end = intervals[i][1];
            }
        }
        // Total run time, O(NLogN + N) = O(NLogN)
        return count;
    }
}
