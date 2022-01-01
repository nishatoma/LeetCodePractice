package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {
        System.out.println(Math.ceil(3.0 / 2));
    }

    public int findDuplicateBySorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    public int findDuplicateUsingSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (seen.contains(nums[i])) {
                return nums[i];
            } else {
                seen.add(nums[i]);
            }
        }
        return Integer.MIN_VALUE;
    }

    public int findDuplicateUsingNegatives(int[] nums) {
        int duplicate = -1;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);

            if (nums[curr] < 0) {
                duplicate = curr;
                break;
            } else {
                nums[curr] *= -1;
            }
        }

        // fix the original array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }

        return duplicate;
    }

    // Time: O(N)
    // Space: O(1)
    public int findDuplicateUsingCycleDetection(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // We entered the cycle, re-assign slow
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
