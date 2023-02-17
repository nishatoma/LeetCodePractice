package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; ++i) {
            // if (nums[i] > target) break;
            for (int j = i + 1; j < len - 2; ++j) {
                int k = j + 1;
                int h = len - 1;
                while (k < h) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[h];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[h]);
                        res.add(list);
                        // move k and h
                        while (k < h && nums[k] == nums[k + 1]) ++k;
                        while (h > k && nums[h] == nums[h - 1]) --h;
                        ++k;
                        --h;
                    } else if (sum > target) {
                        --h;
                    } else if (sum < target) {
                        ++k;
                    }
                    while (j < len - 2 && nums[j] == nums[j + 1]) ++j;
                }
            }
            while (i < len - 3 && nums[i] == nums[i + 1]) ++i;
        }
        return res;
    }
}
