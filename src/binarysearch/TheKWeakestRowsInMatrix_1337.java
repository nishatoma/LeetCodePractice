package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInMatrix_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        for (int row = 0; row < rows; ++row) {
            pq.offer(new int[]{numOnes(mat[row]), row});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (k-- != 0) {
            res[k] = pq.poll()[1];
        }

        return res;

    }

    static int numOnes(int[] arr) {

        if (arr[0] == 0) {
            return 0;
        }

        if (arr[arr.length - 1] == 1) {
            return arr.length;
        }

        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
