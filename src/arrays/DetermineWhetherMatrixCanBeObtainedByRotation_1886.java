package arrays;

class DetermineWhetherMatrixCanBeObtainedByRotation_1886 {
    public boolean findRotation(int[][] mat, int[][] target) {

        boolean result = false;

        for (int i = 0; i < 4; i++) {
            rotateDegrees(mat);
            result = result || comp(mat, target);
        }

        return result;
    }

    void rotateDegrees(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // first transpose mat
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        // Then swap left and right elements, so we can finish rotation
        for (int i = 0; i < r; i++) {
            int left = 0;
            int right = c - 1;
            while (left < right) {
                int tmp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = tmp;
                right--;
                left++;
            }
        }
    }

    boolean comp(int[][] mat, int[][] target) {
        int r = mat.length;
        int c = mat.length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
