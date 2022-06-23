package heap;

import java.util.PriorityQueue;

public class FindKthLargestXORCoordinateValue_1738 {
    // Runs in O(m*nlog(k))
    public int kthLargestValue(int[][] matrix, int k) {
        // Min Queue to get Kth largest
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int top = i <= 0 ? 0 : matrix[i - 1][j];
                int left = j <= 0 ? 0 : matrix[i][j - 1];
                int topLeft = (i <= 0 || j <= 0) ? 0 : matrix[i - 1][j - 1];
                // Get the current xor by top ^ left ^ topLeft ^ matrix[i][j]
                matrix[i][j] = matrix[i][j] ^ top ^ left ^ topLeft;
                // Add to Min Q
                q.offer(matrix[i][j]);
                // Kth largest
                if (q.size() > k) {
                    q.poll();
                }
            }
        }
        // return Kth largest
        return q.poll();
    }
}
