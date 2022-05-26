package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(k, n, curr, res, 1);

        return res;
    }

    private void dfs(int k, int n, List<Integer> curr, List<List<Integer>> res, int idx) {
        // If we have more than k numbers that add up to n,
        // then we break the condition, so just return here
        if (curr.size() > k) return;

        // If we add up to n, and our current list size
        // satisfies k size, then add it to result list.
        if (n == 0 && k == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // for each number from 1 to 10,
        // check if we can use it to sum up to n
        for (int i = idx; i < 10; ++i) {
            // add that number to the list
            curr.add(i);
            // explore more options
            dfs(k, n - i, curr, res, i + 1);
            // back track
            curr.remove(curr.size() - 1);
        }
    }
}
