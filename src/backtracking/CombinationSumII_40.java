package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, combo, candidates, target, 0);

        return result;
    }


    static void backtrack(List<List<Integer>> result,
                          List<Integer> combo,
                          int[] candidates,
                          int target,
                          int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combo.add(candidates[i]);
            backtrack(result, combo, candidates, target - candidates[i], i + 1);
            combo.remove(combo.size() - 1);
        }
    }
}
