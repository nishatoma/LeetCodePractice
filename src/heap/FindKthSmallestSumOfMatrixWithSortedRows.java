package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallestSumOfMatrixWithSortedRows {

    // Time: O(m * n * k * log(k))
    public int kthSmallest(int[][] mat, int k) {
        int c = Math.min(mat[0].length, k);
        // Max PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Add temp number to q
        pq.add(0);
        // for each row
        for (int[] row : mat) {
            // Create another temporary pq
            PriorityQueue<Integer> next = new PriorityQueue<>(Collections.reverseOrder());
            // for each column
            for (int i = 0; i < c; ++i) {
                for (int num : pq) {
                    next.offer(num + row[i]);
                    // If we exceed k
                    if (next.size() > k) {
                        // Keep kicking out largest elements
                        next.poll();
                    }
                }
            }
            // Keep the current sums for next result
            pq = next;
        }
        return pq.poll();
    }
}
