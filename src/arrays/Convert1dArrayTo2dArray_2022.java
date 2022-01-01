package arrays;

class Convert1dArrayTo2dArray_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if ((m * n) != original.length) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[i * n + j];
            }
        }
        return result;
    }
}