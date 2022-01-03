package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        backtrack(result, combo, candidates, target, 0);

        return result;
    }

    private static void backtrack(List<List<Integer>> result,
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
            combo.add(candidates[i]);
            backtrack(result, combo, candidates, target - candidates[i], i);
            combo.remove(combo.size() - 1);
        }
    }
}
