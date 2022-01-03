package backtracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        backtrack(result, combo, k, n, 1);

        return result;
    }

    static void backtrack(List<List<Integer>> result,
                          List<Integer> combo,
                          int k,
                          int n,
                          int start) {
        if (n < 0) {
            return;
        }

        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            if (i >= 1 && i <= 9) {
                combo.add(i);
                backtrack(result, combo, k - 1, n - i, i + 1);
                combo.remove(combo.size() - 1);
            }
        }
    }
}