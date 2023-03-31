package binarysearch;

public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        // Basically, if we can find
        // a number that has K elements <= to it, then we found our answer.
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[rows - 1][cols - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private int countLessOrEqual(int[][] mat, int val) {
        int i = mat.length - 1, j = 0;
        int res = 0;
        while (i >= 0 && j < mat.length) {
            if (mat[i][j] > val) {
                --i;
            } else {
                res += i + 1;
                ++j;
            }
        }
        return res;
    }
}
