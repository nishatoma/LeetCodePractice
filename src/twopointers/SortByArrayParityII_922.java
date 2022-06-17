package twopointers;

public class SortByArrayParityII_922 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length - 1;
        int l = 0;
        int r = 1;
        int[] res = new int[n];

        while (l < n && r < n) {
            if (nums[l] % 2 != 0) {
                swap(nums, l, r);
                r += 2;
            } else {
                l += 2;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
