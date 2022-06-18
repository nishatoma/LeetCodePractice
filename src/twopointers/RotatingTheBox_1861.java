package twopointers;

public class RotatingTheBox_1861 {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length;
        int c = box[0].length;
        char[][] res = new char[c][r];

        for (int i = 0; i < r; ++i) {
            int empty = c - 1;
            for (int j = c - 1; j >= 0; --j) {
                if (box[i][j] == '*') { // obstacle
                    empty = j - 1;
                }
                // stone found, make it empty
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][empty--] = '#';
                }
            }
        }
        // Build second box from first
        for (int i = 0; i < r; ++i) {
            for (int j = c - 1; j >= 0; --j) {
                res[j][r - i - 1] = box[i][j];
            }
        }
        return res;
    }
}
