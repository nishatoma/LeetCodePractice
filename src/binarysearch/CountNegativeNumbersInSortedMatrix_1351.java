package binarysearch;

public class CountNegativeNumbersInSortedMatrix_1351 {

    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int sum = 0, lastNeg = cols - 1;

        for (int row = 0; row < rows; ++row) {
            // First edge case where number in the first
            // column is negative.
            if (grid[row][0] < 0) {
                sum += cols;
                continue;
            }

            // Second edge case, all numbers are positive
            if (grid[row][cols - 1] >= 0) {
                continue;
            }

            // Regular case, binary search for the negative number
            int l = 0, r = lastNeg;

            while (l <= r) {
                int m = l + (r - l) / 2;

                if (grid[row][m] < 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            sum += (cols - l);
            lastNeg = l;
        }

        return sum;
    }
}
