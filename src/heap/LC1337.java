package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        // Make a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Get number of rows and columns
        int rows = mat.length, cols = mat[0].length;
        // For each row
        for (int i = 0; i < rows; ++i) {
            // Define left and right boundaries for column
            int lo = 0, hi = cols - 1;
            int soldiers = 0;
            // Binary search or edge case
            if (mat[i][lo] == 0) {
                soldiers = 0;
            } else if (mat[i][hi] == 1) {
                soldiers = cols;
            } else {
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (mat[i][mid] == 1) {
                        // Look for more soldiers on the right
                        lo = mid + 1;
                    } else {
                        // look left
                        hi = mid - 1;
                    }
                }
                // the # of soldiers is just equal to lo
                soldiers = lo;
            }
            // Add the soldiers and the respective row
            // to the priority queue
            pq.offer(new Pair(i, soldiers));
            // Check limit
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Make a result array of size k
        int[] res = new int[k];
        // Go for each element in the PQ
        // And add the rows
        for (int i = k - 1; i >= 0; --i) {
            res[i] = pq.poll().row;
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int row;
        int soldiers;

        public Pair(int row, int soldiers) {
            this.row = row;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.soldiers != other.soldiers) {
                return Integer.compare(this.soldiers, other.soldiers);
            }
            return Integer.compare(this.row, other.row);
        }
    }
}
