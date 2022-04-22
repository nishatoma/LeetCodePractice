package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray_2089 {

    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanCount = 0;
        int targetCount = 0;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if (num < target) lessThanCount++;
            if (num == target) targetCount++;
        }

        for (int i = 0; i < targetCount; ++i) {
            res.add(lessThanCount++);
        }

        return res;
    }
}
