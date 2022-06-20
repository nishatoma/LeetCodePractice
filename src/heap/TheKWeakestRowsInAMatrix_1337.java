package heap;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        // Rows
        int r = mat.length;
        // Order by # of soldiers, otherwise the row index.
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        // Result array
        int[] res = new int[k];
        // Go over the matrix
        for (int i = 0; i < r; ++i) {
            q.offer(new int[]{numOnes(mat[i]), i});
            // Max Q size
            if (q.size() > k) {
                q.poll();
            }
        }
        // For all the lowest ranking rows, add them to the
        // result array
        while (k-- != 0) {
            res[k] = q.poll()[1];
        }
        return res;
    }

    // Find number of ones using binary search!!
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // If we found a soldier, look to the right
            // for more soldiers
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
