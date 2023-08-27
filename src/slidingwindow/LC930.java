package slidingwindow;

public class LC930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] A, int goal) {
        if (goal < 0) return 0;
        int left = 0;
        int right = 0;
        int n = A.length;
        int res = 0;
        int sum = 0;

        while (right < n) {
            sum += A[right];

            while (sum > goal) {
                sum -= A[left++];
            }

            res += (right - left + 1);

            ++right;
        }
        return res;
    }
}
