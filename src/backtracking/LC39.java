package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        dfs(arr, new int[1], target, 0, list, res);
        return res;
    }

    private void dfs(int[] arr, int[] sum, int t, int start, List<Integer> list, List<List<Integer>> res) {
        if (t < 0) {
            return;
        } else if (t == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < arr.length; ++i) {
                list.add(arr[i]);
                dfs(arr, sum, t - arr[i], i, list, res);
                // Backtrack
                list.remove(list.size() - 1);
            }
        }
    }
}
