package bitmanipulation;

public class LC1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // Basically, we can find max using maximum bit
        // which is (1 << maximumBit) - 1;
        // then we know that the xor for hte entire arr
        // xor ^ k = max
        // therefore, k = max ^ xor
        int xor = 0, n = nums.length;
        int[] res = new int[n];
        int max = (1 << maximumBit) - 1;

        // Find xor of arr
        for (int num : nums) {
            xor ^= num;
        }

        // Go over new array
        for (int i = 0; i < n; ++i) {
            res[i] = xor ^ max;
            // get rid of element in xor arr
            xor ^= nums[n - 1 - i];
        }

        return res;
    }
}
