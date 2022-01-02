package arrays;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int size = matrix.length * matrix[0].length;

        int left = 0;
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while (result.size() < size) {

            for (int j = left; j < right && result.size() < size; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            // Now go top to bottom
            for (int i = top; i < bottom && result.size() < size; i++) {
                result.add(matrix[i][right - 1]);
            }
            right--;
            // Now go from right to left;
            for (int j = right - 1; j >= left && result.size() < size; j--) {
                result.add(matrix[bottom - 1][j]);
            }
            bottom--;
            // Now go from bottom to top
            for (int i = bottom - 1; i >= top && result.size() < size; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
