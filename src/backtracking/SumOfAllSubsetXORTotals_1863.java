package backtracking;

public class SumOfAllSubsetXORTotals_1863 {

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currXor) {
        if (index == nums.length) return currXor;

        int with = dfs(nums, index + 1, currXor ^ nums[index]);
        int wo = dfs(nums, index + 1, currXor);

        return with + wo;
    }
}
