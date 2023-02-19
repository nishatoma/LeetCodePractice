package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LC2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countLessThanTarget = 0;
        int countTarget = 0;
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        // Find how many numbers less than target
        // And how many numbers == target
        for (int i = 0; i < len; ++i) {
            if (nums[i] == target) ++countTarget;
            else if (nums[i] < target) ++countLessThanTarget;
        }
        // Now that we know, we can start adding the indices
        // To our result list
        while (countTarget-- > 0) {
            res.add(countLessThanTarget++);
        }
        return res;
    }
}
