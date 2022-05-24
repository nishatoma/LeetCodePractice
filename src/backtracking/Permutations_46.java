package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, res, curr);

        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> curr) {
        if (nums.length == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // check for duplicate in list
            if (visited[i]) continue;
            // then continue backtracking procedure as usual
            visited[i] = true;
            curr.add(nums[i]);
            dfs(nums, visited, res, curr);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
