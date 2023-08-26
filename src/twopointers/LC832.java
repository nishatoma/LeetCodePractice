package twopointers;

public class LC832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length, cols = image[0].length;
        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            // reverse
            int start = 0, end = cols - 1;
            while (start <= end) {
                res[i][start] = image[i][end];
                res[i][end] = image[i][start];
                ++start;
                --end;
            }
            // flip
            start = 0;
            while (start < cols) {
                res[i][start++] ^= 1;
            }
        }
        return res;
    }
}
