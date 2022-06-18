package twopointers;

public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int numZeros = 0;
        // use snowball method to roll all the zeros as we go
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) numZeros++;
            else if (numZeros > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - numZeros] = temp;
            }
        }
    }
}
