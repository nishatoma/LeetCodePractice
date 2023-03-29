package slidingwindow;

public class LC2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minJ = -1;
        int maxJ = -1;
        int badJ = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                badJ = i;
                minJ = -1;
                maxJ = -1;
            }

            if (nums[i] == minK) {
                minJ = i;
            }

            if (nums[i] == maxK) {
                maxJ = i;
            }
            res += Math.max(0, Math.min(minJ, maxJ) - badJ);
        }
        return res;
    }
}
