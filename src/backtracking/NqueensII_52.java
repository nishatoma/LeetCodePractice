package backtracking;

import java.util.BitSet;

public class NqueensII_52 {

    public int totalNQueens(int n) {

        if (n < 0) return 0;
        if (n == 1) return 1;

        BitSet set = new BitSet(5 * n);

        return backtrack(n, 0, set);
    }

    private int backtrack(int n, int row, BitSet set) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; ++col) {
            int diag45 = n + (row + col);
            int diag135 = 3 * n + (n + row - col);

            // Occupied by a queen
            if (set.get(col) || set.get(diag45) || set.get(diag135)) {
                continue;
            }

            set.set(col);
            set.set(diag45);
            set.set(diag135);
            count += backtrack(n, row + 1, set);
            // backtrack
            set.clear(col);
            set.clear(diag45);
            set.clear(diag135);
        }

        return count;
    }
}
