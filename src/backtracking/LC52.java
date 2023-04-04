package backtracking;

public class LC52 {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        return dfs(0, n, cols, d1, d2);
    }

    private int dfs(int row, int size, boolean[] cols, boolean[] d1, boolean[] d2) {
        int res = 0;
        for (int col = 0; col < size; ++col) {
            int id1 = row - col + size; // for the 135 diagonal
            int id2 = col + row; // for the 45 diagonal
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                if (row == size - 1) {
                    ++res;
                } else {
                    cols[col] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    res += dfs(row + 1, size, cols, d1, d2);
                    cols[col] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
        return res;
    }
}
