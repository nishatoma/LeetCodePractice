package backtracking;

public class CountNumberOfMaximumOrSubsets_2044 {

    public int countMaxOrSubsets(int[] nums) {
        int max = maxOr(nums);

        return helper(nums, 0, max, 0);
    }

    private int helper(int[] nums, int i, int maxOr, int totalOr) {
        if (i == nums.length) return maxOr == totalOr ? 1 : 0;

        int with = helper(nums, i + 1, maxOr, totalOr | nums[i]);
        int wo = helper(nums, i + 1, maxOr, totalOr);

        return wo + with;
    }

    private int maxOr(int[] nums) {

        int maxOr = 0;
        for (int num: nums) {
            maxOr |= num;
        }

        return maxOr;
    }
}
