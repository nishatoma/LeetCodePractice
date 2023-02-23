package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, list);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        // Add the list first to res
        res.add(new ArrayList<>(list));
        // Iterate over the rest of the elements
        for (int i = index; i < nums.length; ++i) {
            // add number to list
            list.add(nums[i]);
            // Recurse
            dfs(nums, i + 1, res, list);
            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}
