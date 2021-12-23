public class KadanesAlgorithm {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, -3, 4, -6, 5, 6, 7};

        System.out.println(findMaxContiguousSubArray(nums));
    }

    // O(n) Solution
    public static int findMaxContiguousSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingAtIndex = nums[0];

        for (int num : nums) {
            maxEndingAtIndex = Math.max(maxEndingAtIndex + num, num);

            maxSoFar = Math.max(maxSoFar, maxEndingAtIndex);
        }

        return maxSoFar;
    }
}
