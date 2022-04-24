package set;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];

        int i = 0;
        for (Integer num : intersect) {
            res[i++] = num;
        }

        return res;
    }

}
