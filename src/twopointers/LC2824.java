package twopointers;

import java.util.Collections;
import java.util.List;

public class LC2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int l = 0, h = n - 1;
        int res = 0;
        while (l < h) {
            int a = nums.get(l);
            int b = nums.get(h);
            if (a + b < target) {
                res += h - l;
                ++l;
            } else {
                --h;
            }
        }
        return res;
    }
}
