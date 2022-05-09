package binarysearch;

public class FindPeakElementII_1901 {

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int lo = 0, hi = m;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int maxRow = 0;
            for (int row = 0; row < n; ++row) {
                if (mat[maxRow][mid] < mat[row][mid]) {
                    maxRow = row;
                }
            }

            // Now we found max row, compare to columns
            if ((mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]) && (mid == m - 1 || mat[maxRow][mid] > mat[maxRow][mid + 1])) {
                return new int[]{maxRow, mid};
            } else if (mid > 0 && mat[maxRow][mid] < mat[maxRow][mid - 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
