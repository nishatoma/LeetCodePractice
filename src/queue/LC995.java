package queue;

public class LC995 {
    public int minKBitFlips(int[] nums, int k) {
        // will come back to this later
        boolean[] flipped = new boolean[nums.length];
        int res = 0;
        int validFlipCount = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) {
                if (flipped[i - k]) {
                    validFlipCount--;
                }
            }

            if (validFlipCount % 2 == nums[i]) {
                if (i + k > nums.length) {
                    return -1;
                }
                validFlipCount++;
                flipped[i] = true;
                res++;
            }
        }
        return res;
    }
}
