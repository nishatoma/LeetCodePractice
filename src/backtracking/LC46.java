package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.LeetCodeUtilsKt.swap;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // need a memo to keep visited nodes out
        Set<Integer> visited = new HashSet<>();
        backtrack(nums, res, list, visited);
        return res;
    }

    // This version of backtracking uses element swapping to avoid duplicates..
    private void backtrack2(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            // iterate
            for (int i = index; i < nums.length; ++i) {
                // Add element and swap to avoid duplicates..
                list.add(nums[i]);
                swap(nums, i, index);
                // dfs
                backtrack2(nums, index + 1, res, list);
                // backtrack
                swap(nums, i, index);
                list.remove(list.size() - 1);
            }
        }
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // For each element, add to array
        for (int i = 0; i < nums.length; ++i) {
            // Get the current element
            int element = nums[i];
            // If already visited, don't bother
            if (!visited.add(element)) continue;
            // Choose it by adding to list
            list.add(element);
            // DFS
            backtrack(nums, res, list, visited);
            // Unchoose
            list.remove(list.size() - 1);
            // unvisit
            visited.remove(element);
        }
    }
}
