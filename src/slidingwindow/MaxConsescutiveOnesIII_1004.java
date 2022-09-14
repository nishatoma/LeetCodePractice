package slidingwindow;

public class MaxConsescutiveOnesIII_1004 {

    public int longestOnes(int[] nums, int k) {
        int max = k;
        int n = nums.length;
        int l = 0;
        int res = -1;

        for (int r = 0; r < n; ++r) {


            if (nums[r] == 0) {
                max--;
            }

            if (max < 0) {
                if (nums[l++] == 0) {
                    max++;
                }
            }

            if (max >= 0) {
                // record max window size
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
