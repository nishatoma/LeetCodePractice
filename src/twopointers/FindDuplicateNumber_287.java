package twopointers;

public class FindDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        // Use fast and slow pointers to solve this algorithm
        // since we can be safe we can use the numbers as indices;
        int fast = nums[nums[0]];
        int slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
