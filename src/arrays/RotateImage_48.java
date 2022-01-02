package arrays;

class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        // Transpose matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // After, just swap rightmost and leftmost items
        // each time
        for (int i = 0; i < r; i++) {
            int start = 0;
            int end = c - 1;
            while (start < end) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }
    }
}
