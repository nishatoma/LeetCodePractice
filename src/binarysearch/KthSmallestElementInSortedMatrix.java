package binarysearch;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length, m = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[n - 1][m - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int j = m - 1;
            int count = 0;

            for (int i = 0; i < n; ++i) {
                while (j >= 0 && matrix[i][j] > mid) j--;

                count += j + 1;
            }

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;

    }

}
