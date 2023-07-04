package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(n, k, res, list, 1);

        return res;
    }

    private void dfs(int n, int k, List<List<Integer>> res, List<Integer> list, int curr) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = curr; i <= n - (k - list.size()) + 1; ++i) {
            list.add(i);
            dfs(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
