package arrays;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        if (nums.length == 0) {
            return 0;
        }

        int count = 0;

        for (int j : nums) {
            set.add(j);
        }

        for (Integer num : set) {
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currCount = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currCount++;
                }
                count = Math.max(count, currCount);
            }
        }
        return count;
    }
}