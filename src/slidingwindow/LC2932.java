package slidingwindow;

public class LC2932 {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int x = nums[i];
                int y = nums[j];

                if (Math.abs(x - y) <= Math.min(x, y)) {
                    max = Math.max(max, x ^ y);
                }
            }
        }

        return max;
    }
}
