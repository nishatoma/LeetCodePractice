package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        // 1) Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> (Integer.compare(i1[0], i2[0])));

        // Temporary result list
        List<int[]> inters = new ArrayList<>();

        // Create temporary interval for merging
        int[] temp = intervals[0];
        inters.add(temp);

        // 2) Iterate over the intervals
        for (int[] inter : intervals) {
            // 3) Check if two intervals overlap
            if (doesIntervalOverlap(temp[1], inter[0])) {
                // Merge intervals
                temp[1] = Math.max(temp[1], inter[1]);
            } else {
                // Otherwise, add to list
                temp = inter;
                inters.add(temp);
            }
        }
        // Convert list to array
        return inters.toArray(new int[inters.size()][]);
    }

    boolean doesIntervalOverlap(int aFinish, int bStart) {
        return bStart <= aFinish;
    }
}
