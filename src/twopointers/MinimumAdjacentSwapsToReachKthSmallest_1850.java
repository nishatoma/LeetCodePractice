package twopointers;

public class MinimumAdjacentSwapsToReachKthSmallest_1850 {
    public int getMinSwaps(String num, int k) {
        int res = 0;
        int n = num.length();
        int[] nums = new int[n];
        int[] orig = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = num.charAt(i) - '0';
            orig[i] = num.charAt(i) - '0';
        }

        // Get the kth permutation
        while (k-- != 0) {
            nextPermutation(nums);
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] == orig[i]) continue;

            int j = i + 1;

            while (j < n && orig[i] != nums[j]) j++;

            while (i < j) {
                swap(nums, j - 1, j);
                res++;
                j--;
            }
        }
        return res;
    }

    private void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start; int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
