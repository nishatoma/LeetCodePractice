package dp;

public class RangeSumQueryImmutable303 {

    private final int[] nums;

    public RangeSumQueryImmutable303(int[] nums) {
        this.nums = nums;

        // prefix sum
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] = nums[i] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.nums[right];
        }
        return this.nums[right] - this.nums[left - 1];

    }

}
