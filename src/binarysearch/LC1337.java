package binarysearch;

import java.util.PriorityQueue;

public class LC1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        // Get a max Queue
        PriorityQueue<RowPair> pq = new PriorityQueue<>((a, b) -> b.score == a.score ? b.row - a.row : b.score - a.score);
        // get size
        int m = mat.length, n = mat[0].length;
        // iterate
        for (int i = 0; i < m; ++i) {
            // binary search
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                // check element
                if (mat[i][mid] == 1) {
                    // We have a soldier, keep checking right
                    lo = mid + 1;
                } else {
                    // check left
                    hi = mid;
                }
            }
            // if we have lo, then we know the # of soldiers is lo + 1
            // Make a pair here and store in Q...
            RowPair pair = new RowPair(i, lo + 1);
            // Store pair in queue
            pq.offer(pair);
            // check size of q
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Now, get a result size of k..
        int[] res = new int[k];
        // Iterate over the queue and assign to res
        for (int i = k - 1; i >= 0; --i) {
            res[i] = pq.poll().row;
        }
        return res;
    }

    // RowPair
    class RowPair {
        private int row;
        private int score;

        public RowPair(int row, int score) {
            this.row = row;
            this.score = score;
        }
    }
}
