package dp;

public class CountSquareSubMatricesWithAllOnes_1277 {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) continue;
                // Otherwise, calculate the bottom most corner
                if (i >= 1 && j >= 1) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
