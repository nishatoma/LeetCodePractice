package heap;

public class KthSmallestElementInSortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // We will binary search the space from lowest -> highest #
        // [1,5,9,10,11,12,13,13,15], K = 8, will return 13
        // since there are at least 8 numbers <= 13
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        // binary search for numbers such that
        // the number we pick is the smallest that satisfy the
        // property of having at least k elements smaller than or equal to it.
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqualNum(matrix, mid);
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private int getLessEqualNum(int[][] matrix, int num) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            // If number is <= num, then we know the numbers
            // before it in previous rows also work
            if (matrix[row][col] <= num) {
                count += row + 1;
                // visit next column
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
