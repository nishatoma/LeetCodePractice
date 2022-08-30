package intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Get temp list
        List<int[]> list = new ArrayList<>();
        // Get index
        int i = 0;
        // Start and end
        int start = newInterval[0];
        int end = newInterval[1];
        // Go over current intervals
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            // Add non-overlapping intervals to the list
            list.add(intervals[i++]);
        }

        // Go over the overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // Merge intervals into new one and add
            start = Math.min(newInterval[0], intervals[i][0]);
            end = Math.max(newInterval[1], intervals[i++][1]);
            // Update new interval
            newInterval[0] = start;
            newInterval[1] = end;
        }
        // Add the new interval to the list
        list.add(newInterval);
        // Go over remaining intervals
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        // Convert list to array in the end
        return list.toArray(new int[list.size()][]);
    }
}
