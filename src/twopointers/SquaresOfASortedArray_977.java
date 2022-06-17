package twopointers;

public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int l = 0;
        int r = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if ((nums[l] * nums[l]) <= (nums[r] * nums[r])) {
                res[i] = nums[r] * nums[r];
                r--;
            } else {
                res[i] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }
}
