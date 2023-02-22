package backtracking;

public class LC1863 {
    public int subsetXORSum(int[] nums) {
        return getTotalScore(nums, 0, nums[0]);
    }

    private int getTotalScore(int[] nums, int i, int currentXor) {
        if (i == nums.length) return currentXor;

        int pick = getTotalScore(nums, i + 1, nums[i] ^ currentXor);
        int notPick = getTotalScore(nums, i + 1, currentXor);

        return pick + notPick;
    }
}
