package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        add(k, n, 1, list, res);
        return res;
    }

    private void add(int k, int target, int curr, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = curr; i < 10; ++i) {
            list.add(i);
            add(k, target - i, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
