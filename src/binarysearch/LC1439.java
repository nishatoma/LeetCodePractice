package binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1439 {
    public int kthSmallest(int[][] mat, int k) {
        // Just use a Priority Queue
        // and keep updating it each time for each row

        // Cols
        int cols = Math.min(mat[0].length, k);

        // Make a MAX priority queue using collections.reverseOrder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Make smallest sum 0 at first
        pq.offer(0);
        // Iterate
        for (int[] row : mat) {
            // Make a new priority queue for each row
            PriorityQueue nextPq = new PriorityQueue<>(Collections.reverseOrder());

            // Iterate for each number in our priority queue
            for (int num : pq) {
                // Iterate for each column
                for (int j = 0; j < cols; ++j) {
                    nextPq.offer(row[j] + num);
                    // Update the PQ
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }

            // Assign our pq to nextPq..
            pq = nextPq;
        }
        // return kth smallest by popping from a max Q
        return pq.poll();
    }
}
