package backtracking;

public class LC2044 {
    public int countMaxOrSubsets(int[] nums) {
        int totalOr = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            totalOr |= nums[i];
        }

        return getScore(nums, 0, 0, totalOr);
    }

    private int getScore(int[] nums, int index, int currOr, int totalOr) {
        if (index == nums.length) {
            if (currOr == totalOr) return 1;
            return 0;
        }

        int pick = getScore(nums, index + 1, nums[index] | currOr, totalOr);
        int notPick = getScore(nums, index + 1, currOr, totalOr);

        return pick + notPick;
    }
}
