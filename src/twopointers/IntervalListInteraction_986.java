package twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntervalListInteraction_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0) return new int[0][0];
        if (secondList == null || secondList.length == 0) return new int[0][0];
        int n = firstList.length;
        int m = secondList.length;
        // Keep track of first and second interval array
        int i = 0;
        int j = 0;
        // Result list
        List<int[]> res = new ArrayList<>();

        while (i < n && j < m) {
            // Get the intervals
            int[] inter1 = firstList[i];
            int[] inter2 = secondList[j];
            // get min and max
            int max = Math.max(inter1[0], inter2[0]);
            int min = Math.min(inter1[1], inter2[1]);
            // if the two intervals are within each
            // other's range, then, the min should be
            // bigger than the max
            if (min >= max) {
                // Then add their range here
                res.add(new int[]{max, min});
            }
            // Check if we should move on with other intervals
            // by seeing if the min is equal one of the intervals'
            // ending range.
            if (min == inter1[1]) ++i;
            if (min == inter2[1]) ++j;
        }
        return res.toArray(new int[0][0]);
    }
}
