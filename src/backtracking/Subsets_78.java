package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(nums, 0, curr, res);

        return res;
    }

    private static void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; ++i) {
            // get curr list
            curr.add(nums[i]);
            dfs(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
