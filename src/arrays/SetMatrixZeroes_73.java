package arrays;

class SetMatrixZeroes_73 {
    
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            // let's use a special variable of the very first
            // cell i.e matrix[0][0]
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            // if an element is 0, set the very first element in the column
            // and the very first element in the row to zero.
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Iterate through the matrix, and whenever we see that
        // the beginning or of a row or column is equal, that means
        // we update that element to zero.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // now check the first very first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}