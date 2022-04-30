package binarysearch;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {

        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        Arrays.sort(nums);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= len - mid) {
                if (mid == 0 || nums[mid - 1] < len - mid) {
                    return len - mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
