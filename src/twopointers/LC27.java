package twopointers;

public class LC27 {
    public int removeElement(int[] nums, int val) {
        // Idea is to just swap bad elements with good elements
        // keep track of bad element index whenever we see a good element
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                // replace with index with bad element
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k++] = temp;
            }
        }
        return k;
    }
}
