package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(n, k, new ArrayList<>(), res, 1);

        return res;
    }

    private void dfs(int n, int k, List<Integer> curr, List<List<Integer>> res, int idx) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }


        for (int i = idx; i <= n - (k - curr.size()) + 1; ++i) {
            curr.add(i);
            dfs(n, k, curr, res, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
