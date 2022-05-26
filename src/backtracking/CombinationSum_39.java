package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, new ArrayList<>(), res, 0);

        return res;
    }

    private void dfs(int[] nums, int target, List<Integer> curr, List<List<Integer>> res, int idx) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            curr.add(nums[i]);
            dfs(nums, target - nums[i], curr, res, i);
            // back track
            curr.remove(curr.size() - 1);
        }
    }
}
