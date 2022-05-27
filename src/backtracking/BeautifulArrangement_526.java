package backtracking;

public class BeautifulArrangement_526 {

    public int countArrangement(int n) {
        if (n <= 3) return n;

        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = i;
        }

        return count(nums, n);

    }

    private int count(int[] nums, int n) {

        if (n == 0) {
            return 1;
        }

        int res = 0;

        for (int i = n; i > 0; --i) {
            swap(nums, i, n);
            if (nums[n] % n == 0 || n % nums[n] == 0) {
                res += count(nums, n - 1);
            }
            swap(nums, i, n);
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
