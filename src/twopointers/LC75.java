package twopointers;

public class LC75 {
    public void sortColors(int[] nums) {
        // We can represent n0, n1 and n2 for indices
        // for 0, 1 and 2 respectively. When we see a zero, we have to move
        // both n1 and n2, but not n0
        // When we see a 1, we have to move n1 and n2, since they come after zero
        // if we see a 2, we just have to move n2
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            } else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            } else if (nums[i] == 2) {
                nums[++n2] = 2;
            }
        }
    }
}
