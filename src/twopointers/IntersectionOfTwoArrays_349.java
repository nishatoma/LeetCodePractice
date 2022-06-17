package twopointers;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        for (int num : nums1) {
            first.add(num);
        }

        Set<Integer> sec = new HashSet<>();
        for (int num : nums2) {
            sec.add(num);
        }

        Set<Integer> res1 = new HashSet<>();
        for (int num : first) {
            if (sec.contains(num)) res1.add(num);
        }

        int[] res = new int[res1.size()];
        int i = 0;
        for (int num : res1) {
            res[i++] = num;
        }
        return res;
    }
}
