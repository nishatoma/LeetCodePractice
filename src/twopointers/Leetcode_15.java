package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // Init the result
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array first
        Arrays.sort(nums);
        // Get length
        int len = nums.length;
        // iterate through the array
        // We stop at 3rd last element since we need i j and k to be different
        for (int i = 0; i < len - 2; ++i) {
            // If nums[i] > 0, no point in continuing
            if (nums[i] > 0) break;
            // Get j
            int j = i + 1;
            // Get k
            int k = len - 1;
            // Iterate to find target sum
            while (j < k) {
                // Get the sum
                int sum = nums[i] + nums[j] + nums[k];
                // check the sum
                if (sum == 0) {
                    // Here, we need to make sure we avoid duplicates, not by using
                    // set, but just by skipping the duplicate elements in the array
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    // then add to result
                    res.add(list);
                    // Then we check for duplicate j/k values
                    while (j < k && nums[j] == nums[j + 1]) {
                        // just skip the duplicate
                        j++;
                    }
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (sum < 0) ++j;
                else if (sum > 0) --k;
            }
            // Skip duplicate i values
            while (i < len - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}
